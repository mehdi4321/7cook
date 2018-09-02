package com.example.mehdi.a7cook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;

import com.android.volley.Response;
import com.example.mehdi.a7cook.adapters.BannerAdapter;
import com.example.mehdi.a7cook.adapters.CategoryAdapter;
import com.example.mehdi.a7cook.adapters.RecipeAdapter;
import com.example.mehdi.a7cook.data.Banners;
import com.example.mehdi.a7cook.data.Category;
import com.example.mehdi.a7cook.data.Recipes;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ApiService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         apiService=new ApiService(this);


        setupViews();
    }

    private void setupViews() {
        Toolbar toolbar=findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getBanners();
        getCategory();
        getRecipes();
    }
    public void getRecipes(){
        apiService.getRecipes(new Response.Listener<List<Recipes>>() {
            @Override
            public void onResponse(List<Recipes> response) {
                RecyclerView recyclerView=findViewById(R.id.rv_main_recipe);
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(
                        2,StaggeredGridLayoutManager.VERTICAL
                ));
                recyclerView.setAdapter(new RecipeAdapter(response));
            }
        });
    }
    public void getCategory(){
        apiService.getCategories(new Response.Listener<List<Category>>() {
            @Override
            public void onResponse(List<Category> category) {
                RecyclerView recyclerView=findViewById(R.id.rv_main_category);
                recyclerView.setLayoutManager(new LinearLayoutManager(
                        MainActivity.this,LinearLayoutManager.HORIZONTAL,false
                ));
                recyclerView.setAdapter(new CategoryAdapter(category));
            }
        });
    }
    public void getBanners(){
        apiService.getBanners(new Response.Listener<List<Banners>>() {
            @Override
            public void onResponse(List<Banners> banners) {
                RecyclerView recyclerView=findViewById(R.id.rv_main_slider);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
                recyclerView.setAdapter(new BannerAdapter(banners));

                SnapHelper snapHelper=new PagerSnapHelper();
                snapHelper.attachToRecyclerView(recyclerView);
            }
        });
    }
}
