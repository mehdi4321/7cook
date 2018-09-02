package com.example.mehdi.a7cook.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mehdi.a7cook.data.Banners;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.bannerViewHolder> {
    private List<Banners> banners;
    public BannerAdapter (List<Banners> banners){

        this.banners = banners;
    }
    @NonNull
    @Override
    public bannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ImageView imageView=new ImageView(parent.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        imageView.setAdjustViewBounds(true);
        return new bannerViewHolder(imageView);
    }

    @Override
    public void onBindViewHolder(@NonNull bannerViewHolder holder, int position) {
        holder.bindBanner(banners.get(position));
    }

    @Override
    public int getItemCount() {
        return banners.size() ;
    }

    public class bannerViewHolder extends RecyclerView.ViewHolder{
        private ImageView bannerImageView;
        public bannerViewHolder(View itemView) {
            super(itemView);
            bannerImageView = (ImageView) itemView;
        }
        public void bindBanner(Banners banners){
            Picasso.get().load(banners.getImg()).into(bannerImageView);
        }
    }

}
