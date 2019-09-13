package com.example.binqitassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Activity2_HomePage extends AppCompatActivity {

    private TextView mTextViewResult;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2__home_page);

        mTextViewResult = findViewById(R.id.results);
        Button buttonParse = findViewById(R.id.showlist);

        mQueue = Volley.newRequestQueue(this);

        buttonParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });
    }

    private void jsonParse() {
        String url = "http://www.omdbapi.com/?s=Home&apikey=94a221d";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("Search");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject search = jsonArray.getJSONObject(i);

                        String title = search.getString("Title");
                        String year = search.getString("Year");

                        mTextViewResult.append(title + ", " + year + "\n\n");

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }
        );

        mQueue.add(request);

    }

    public void launchpage (View view) {
        Log.d("Tejas", "Going to Launch Page!");

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void moviedetailpage (View view) {
        Log.d("Tejas", "Going to Launch Page!");

        Intent i = new Intent(this, Activity3_Movie_Details.class);
        startActivity(i);
    }

}
