package com.example.mehdi.a7cook.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mehdi.a7cook.R;
import com.example.mehdi.a7cook.data.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private List<Category> categorys;
    public CategoryAdapter(List<Category> categorys){

        this.categorys = categorys;
    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_categori,parent,false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.bindCategory(categorys.get(position));
    }

    @Override
    public int getItemCount() {
        return categorys.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        private ImageView categoryImage;
        private TextView categoryTitle;
        public CategoryViewHolder(View itemView) {
            super(itemView);
            categoryImage=itemView.findViewById(R.id.iv_category_icon);
            categoryTitle=itemView.findViewById(R.id.tv_Category);
        }
        public void bindCategory(Category category){
            Picasso.get().load(category.getImg()).into(categoryImage);
            categoryTitle.setText(category.getTitle());
        }
    }
}
