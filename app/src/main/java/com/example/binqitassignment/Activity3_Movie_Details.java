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

public class Activity3_Movie_Details extends AppCompatActivity {

    private TextView mTextViewResult3;
    private RequestQueue mQueue3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3__movie__details);

        mTextViewResult3 = findViewById(R.id.results3);
        Button buttonParse3 = findViewById(R.id.showlist3);

        mQueue3 = Volley.newRequestQueue(this);

        buttonParse3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });

    }

    private void jsonParse() {
        String url = "http://www.omdbapi.com/?i=tt0099785&apikey=94a221d";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject search = jsonArray.getJSONObject(i);

                        String title = search.getString("Title");
                        String year = search.getString("Year");

                        mTextViewResult3.append(title + ", " + year + "\n\n");

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

        mQueue3.add(request);

    }

    public void homepage (View view) {
        Log.d("Tejas", "Going to Home Page!");

        Intent i = new Intent(this, Activity2_HomePage.class);
        startActivity(i);
    }

}
