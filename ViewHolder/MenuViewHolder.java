package android.example.com.imhungry.ViewHolder;

import android.example.com.imhungry.Interface.ItemClickListener;
import android.example.com.imhungry.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public ImageView imgMenu;
    public TextView txtvMenu;
    ItemClickListener itemClickListener;
    public MenuViewHolder(View itemView) {
        super(itemView);
        imgMenu = itemView.findViewById(R.id.imgv_menu);
        txtvMenu = itemView.findViewById(R.id.txtv_menu_name);
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
