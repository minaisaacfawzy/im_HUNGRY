package android.example.com.imhungry;

import android.content.Intent;
import android.example.com.imhungry.Interface.ItemClickListener;
import android.example.com.imhungry.Model.Category;
import android.example.com.imhungry.Model.Food;
import android.example.com.imhungry.ViewHolder.FoodViewHolder;
import android.example.com.imhungry.ViewHolder.MenuViewHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class FoodList extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseRecyclerAdapter<Food,FoodViewHolder> adapter;
    String categoryId;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Foods");
        recyclerView = findViewById(R.id.recycler_view_food);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        if(getIntent() != null){
            categoryId = getIntent().getStringExtra("categoryId");
            Log.i("Fooooooooood list", "onCreate: " + categoryId);
        }
        if(!categoryId.isEmpty() && categoryId != null){
            loadListFood(categoryId);
            Log.i("Fooooooooood list", "onCreate: " + categoryId);
        }

    }
//    private void loadMenu() {
//        adapter = new FirebaseRecyclerAdapter<Category, MenuViewHolder>(Category.class,R.layout.menu_item,MenuViewHolder.class,databaseReference) {
//            @Override
//            protected void populateViewHolder(MenuViewHolder viewHolder, final Category model, final int position) {
//                viewHolder.txtvMenu.setText(model.getName());
//                Picasso.get().load(model.getImageLink()).into(viewHolder.imgMenu);
//                viewHolder.setItemClickListener(new ItemClickListener() {
//                    @Override
//                    public void onClick(View view, int postion, boolean isLongClick) {
//                        Intent intent = new Intent(home.this,FoodList.class);
//                        intent.putExtra("categoryId",adapter.getRef(position).getKey());
//                        startActivity(intent);
//                    }
//                });
//            }
//        };
//        recyclerView.setAdapter(adapter);
//    }
//ToDo: load listofFood by category id
    private void loadListFood(String categoryId) {
        adapter = new FirebaseRecyclerAdapter<Food, FoodViewHolder>(Food.class,
                R.layout.food_item,
                FoodViewHolder.class,
                databaseReference.orderByChild("menuId").equalTo(categoryId)) {
            @Override
            protected void populateViewHolder(FoodViewHolder viewHolder, final Food model, int position) {
                viewHolder.txtvFood.setText(model.getName());
                Picasso.get().load(model.getImage()).into(viewHolder.imgFood);
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int postion, boolean isLongClick) {
                        Toast.makeText(FoodList.this,""+model.getName(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        };
                recyclerView.setAdapter(adapter);
    }
}
