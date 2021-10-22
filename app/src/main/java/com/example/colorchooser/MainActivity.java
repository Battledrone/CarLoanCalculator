package com.example.colorchooser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.layout);

        int color = 0xFFFF00FF;
        layout.setBackgroundColor(color);
    }
    public void onResume() {
        super.onResume();
        getSharedPreferences("My Color Preferences", Context.MODE_PRIVATE);
        int color = sharedPref.getString("colorfield");
    }

}