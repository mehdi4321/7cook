package com.example.mehdi.a7cook;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.mehdi.a7cook.data.Banners;
import com.example.mehdi.a7cook.data.Category;
import com.example.mehdi.a7cook.data.Recipes;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class ApiService {
    private Context context;

    public ApiService(Context context) {

        this.context = context;
    }

    public void getRecipes(Response.Listener<List<Recipes>> recipeListener) {
        GsonRequest<List<Recipes>> request = new GsonRequest<>(Request.Method.GET,
                "https://api.myjson.com/bins/n7bxs",
                new TypeToken<List<Recipes>>() {
                }.getType(),
                recipeListener,
         new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", "onErrorResponse: ");
            }
        });


        Volley.newRequestQueue(context).add(request);

    }

    public void getBanners(Response.Listener<List<Banners>> bannerListener) {
        GsonRequest<List<Banners>> request = new GsonRequest<>(Request.Method.GET,
                "https://api.myjson.com/bins/110sw0",
                new TypeToken<List<Banners>>() {
                }.getType(),
                bannerListener,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG", "onErrorResponse: ");
                    }
                });


        Volley.newRequestQueue(context).add(request);
    }

    public void getCategories(Response.Listener<List<Category>> categoriListener) {
        GsonRequest<List<Category>> request = new GsonRequest<>(Request.Method.GET,
                "https://api.myjson.com/bins/v0bog",
                new TypeToken<List<Category>>() {
                }.getType(),
                categoriListener,
         new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", "onErrorResponse: ");
            }
        });


        Volley.newRequestQueue(context).add(request);
    }
}
