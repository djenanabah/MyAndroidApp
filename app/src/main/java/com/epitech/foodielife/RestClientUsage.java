package com.epitech.foodielife;

/**
 * Created by Tsy-jon on 30/04/2017.
 */

import android.app.Activity;
import android.util.Log;
import org.json.*;

import com.epitech.foodielife.beans.Dish;
import com.epitech.foodielife.beans.Mark;
import com.epitech.foodielife.beans.Restaurant;
import com.epitech.foodielife.beans.UserClientInfo;
import com.loopj.android.http.*;
import cz.msebera.android.httpclient.Header;


/**
 * Created by LAU on 27/04/2017.
 */

public class RestClientUsage {
    private final Activity activity;
    public static boolean endRequestAll;

    public RestClientUsage(Activity activity)
    {
        this.endRequestAll = false;
        this.activity = activity;
    }
/*
    public void  register(RequestParams params) throws JSONException {
        RestClient.get("adduser", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject jsonObject)
            {

            }
        });
    }*/

    public void login(final String value) throws JSONException {
        RequestParams params = new RequestParams();
        params.put("token", value);

        RestClient.post("login", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.i("RestClientUsage", "OnSuccess");
                ((LoginActivity)activity).updateUserInfo(response);
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject jsonObject)
            {
                if (jsonObject != null) {
                    Log.i("RCU - OnFailure", jsonObject.toString());
                }
                else {
                    Log.i("RCU login - OnFailure", "jsonObject == null");
                }
            }
        });
    }

    public void addDishPost(UserClientInfo user, Dish dish, Mark mark){
        RequestParams params = new RequestParams();
        params.put("user", user);
        params.put("value", dish);
        RestClient.post("", params, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                //TODO : message on success
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                //TODO : message on failure
            }
        });
    }

    public void add_restaurant(UserClientInfo user, Restaurant restaurant)
    {
        RequestParams params = new RequestParams();
        params.put("user", user);
        params.put("value", restaurant);
        RestClient.post("restaurant/add", params, new JsonHttpResponseHandler() {
        @Override
        public void onSuccess(int statusCode, Header[] headers, JSONObject response)
        {
            Log.i("RestClientUsage", "OnSuccess");
            try {
                ((RestaurantFormActivity)activity).addRestaurantSuccess(response);
            } catch (JSONException e) {
                ((RestaurantFormActivity)activity).addRestaurantFailure();
            }
        }
        @Override
        public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject jsonObject)
        {
            ((RestaurantFormActivity)activity).addRestaurantFailure();
            //Log.i("RCU - OnFailure", jsonObject.toString());
        }
        });
    }

    public void get_restaurants(UserClientInfo user)
    {
        RequestParams params = new RequestParams();
        params.put("user", user);
        RestClient.post("restaurant/add", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response)
            {
                try {
                    ((MapsActivity)activity).getRestaurantsSuccess(response);
                } catch (JSONException e) {
                    ((MapsActivity)activity).getRestaurantsFailure();
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject jsonObject)
            {
                ((MapsActivity)activity).getRestaurantsFailure();
            }
        });
    }
}
