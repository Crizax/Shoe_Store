package com.example.shoeapp.Utils.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoeapp.R;
import com.example.shoeapp.Utils.model.ShoeItem;

import java.util.List;

public class ShoeItemAdapter extends RecyclerView.Adapter<ShoeItemAdapter.ShoeItemViewHolder> {


    private List<ShoeItem> shoeItemList;
    private ShoeClickedListener shoeClickedListener;
    public ShoeItemAdapter(ShoeClickedListener shoeClickedListener ){
        this.shoeClickedListener = shoeClickedListener;
    }

    public void setShoeItemList(List<ShoeItem> shoeItemList){
        this.shoeItemList = shoeItemList;
    }

    @NonNull
    @Override
    public ShoeItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_shoe , parent , false);
        return new ShoeItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoeItemViewHolder holder, int position) {
        ShoeItem shoeItem = shoeItemList.get(position);
        holder.shoeNameTv.setText(shoeItem.getShoeName());
        holder.shoeBrandNameTv.setText(shoeItem.getShoeBrandName());
        holder.shoeImageView.setImageResource(shoeItem.getShoeImage());
        holder.shoePriceTv.setText(String.valueOf(shoeItem.getShoePrice()));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shoeClickedListener.onCardClickListener(shoeItem);
            }
        });

        holder.addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shoeClickedListener.addToCartBtnClicked(shoeItem);

            }
        });


    }

    @Override
    public int getItemCount() {
      if (shoeItemList == null){
          return 0;
      }else {
          return shoeItemList.size();
      }
    }

    public class ShoeItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView shoeImageView , addToCartBtn;
        private TextView shoeNameTv , shoeBrandNameTv , shoePriceTv;
        private CardView cardView;


        public ShoeItemViewHolder(@NonNull View itemView) {
            super(itemView);
                cardView = itemView.findViewById(R.id.eachShoeCardView);
                addToCartBtn = itemView.findViewById(R.id.eachShoeAddToCartBtn);
                shoeNameTv = itemView.findViewById(R.id.eachShoeName);
                shoeImageView = itemView.findViewById(R.id.eachShoeIv);
                shoeBrandNameTv = itemView.findViewById(R.id.eachShoeBrandNameTv);
                shoePriceTv = itemView.findViewById(R.id.eachShoePriceTv);

        }
    }
    public interface ShoeClickedListener{
        void onCardClickListener(ShoeItem shoe);
        void addToCartBtnClicked(ShoeItem shoeItem);
    }
}
