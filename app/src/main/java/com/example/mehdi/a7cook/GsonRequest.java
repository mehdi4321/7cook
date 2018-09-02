package com.example.mehdi.a7cook;

import android.support.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GsonRequest<T> extends Request<T> {
    private Response.Listener<T> responseListener;
    private Gson gson = new Gson();
   // private Class<T> clazz;
    private Type type;

    public GsonRequest(int method, String url, Type type, Response.Listener<T> responseListener, @Nullable Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.type=type;
        this.responseListener=responseListener;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        String json = new String(response.data);
        return (Response<T>) Response.success(gson.fromJson(json, type), HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    protected void deliverResponse(T response) {
        responseListener.onResponse(response);
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
//        Map<String,String> map=new HashMap<>();
//        map.put("Authorization","Bearer Your Token");
//       map.put("Key","Value");
//        return map;
        return super.getHeaders();
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
//        JSONObject jsonObject=new JSONObject();
//        try {
//            jsonObject.put("email","test@gmail.com");
//            jsonObject.put("password","123456");
//        } catch (JSONException e) {
//
//        }
//
//        return jsonObject.toString().getBytes();
        return super.getBody();
    }
}
