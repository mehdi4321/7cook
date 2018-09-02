package com.example.mehdi.a7cook.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.mehdi.a7cook.R;
import com.example.mehdi.a7cook.data.Recipes;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {
    private  List<Recipes> recipes;

    public RecipeAdapter(List<Recipes> recipes){

        this.recipes = recipes;
    }
    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecipeViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_recipe,parent,false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        holder.bindRecipe(recipes.get(position));
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageViewRecipe;
        private TextView titleTv;
        private TextView descriptionTv;
        private TextView authorTv;
        private RatingBar ratingBarRecipe;
        public RecipeViewHolder(View itemView) {
            super(itemView);
            imageViewRecipe=itemView.findViewById(R.id.iv_recipe);
            titleTv=itemView.findViewById(R.id.tv_recipe_title);
            descriptionTv=itemView.findViewById(R.id.tv_recipe_description);
            authorTv=itemView.findViewById(R.id.tv_recipe_author);
            ratingBarRecipe=itemView.findViewById(R.id.ratingBar_recipe);
        }
        public void bindRecipe(Recipes recipes){
            Picasso.get().load(recipes.getImg()).into(imageViewRecipe);
            titleTv.setText(recipes.getTitle());
            descriptionTv.setText(recipes.getDesc());
            authorTv.setText("By"+recipes.getBy());
            ratingBarRecipe.setRating(recipes.getRate());

        }
    }
}
