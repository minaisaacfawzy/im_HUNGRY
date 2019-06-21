package android.example.com.imhungry.ViewHolder;

import android.example.com.imhungry.Interface.ItemClickListener;
import android.example.com.imhungry.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public ImageView imgFood;
    public TextView txtvFood;

    private ItemClickListener itemClickListener;

    public FoodViewHolder(View itemView) {
        super(itemView);
        imgFood = itemView.findViewById(R.id.imgv_food);
        txtvFood= itemView.findViewById(R.id.txtv_food_name);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);
    }
}
