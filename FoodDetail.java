package android.example.com.imhungry;

import android.example.com.imhungry.Model.Food;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class FoodDetail extends AppCompatActivity {
    TextView foodName,foodDescription,foodPrice;
    ImageView foodImage;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnCart;
    ElegantNumberButton numberButton;

    String foodId = "";

    FirebaseDatabase database;
    DatabaseReference foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        database = FirebaseDatabase.getInstance();
        foods = database.getReference("Foods");

        numberButton = findViewById(R.id.number_button);
        btnCart = findViewById(R.id.btn_cart);

        foodDescription = findViewById(R.id.txtv_food_description);
        foodPrice = findViewById(R.id.txtv_food_price);
        foodName = findViewById(R.id.txtv_food_name);

        foodImage = findViewById(R.id.imgv_food_detail);

        collapsingToolbarLayout = findViewById(R.id.coll_toolbar_food_detail);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
        collapsingToolbarLayout.setExpandedTitleColor(R.style.ExpandedAppBar);

        if(getIntent() != null)
            foodId = getIntent().getStringExtra("foodId");
        if(!foodId.isEmpty())
            getDetailFood(foodId);


    }

    private void getDetailFood(String foodId) {
        foods.child(foodId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Food food = dataSnapshot.getValue(Food.class);

                Picasso.get().load(food.getImage()).into(foodImage);
                collapsingToolbarLayout.setTitle(food.getName());
                foodPrice.setText(food.getPrice());
                foodName.setText(food.getName());
                foodDescription.setText(food.getDescription());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}
