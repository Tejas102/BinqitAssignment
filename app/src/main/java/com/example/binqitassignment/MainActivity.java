package com.example.binqitassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnstart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void homepage (View view) {
        Log.d("Tejas", "Going to Home Page!");

        Intent i = new Intent(this, Activity2_HomePage.class);
        startActivity(i);
    }

}
