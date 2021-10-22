package com.example.colorchooser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ColorPicker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);
    }
    private void initSettings() {
        SharedPreferences sharedPref = getSharedPreferences("MyColorPreferences",
                Context.MODE_PRIVATE);
        String sortBy = sharedPref.getString("colorfield", "blue");

        RadioButton rbRed = findViewById(R.id.radioRed);
        RadioButton rbBlue = findViewById(R.id.radioBlue);
        RadioButton rbPurple = findViewById(R.id.radioPurple);
        RadioButton rbGreen = findViewById(R.id.radioGreen);
        if (sortBy.equals("red")) {
            rbRed.setChecked(true);
        } else if (sortBy.equals("blue")) {
            rbBlue.setChecked(true);
        } else if (sortBy.equals("purple")) {
            rbPurple.setChecked(true);
        }
        else {
            rbGreen.setChecked(true);

        }


    }

    private void initRadioGroupSortBy() {
        RadioGroup rg = findViewById(R.id.radioGroupColor);
        RadioButton rbRed = findViewById(R.id.radioRed);
        RadioButton rbBlue = findViewById(R.id.radioBlue);
        RadioButton rbPurple = findViewById(R.id.radioPurple);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (rbRed.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("MyColorPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("colorfield", "red");
                    editor.apply();

                } else if (rbBlue.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("MyColorPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("colorfield", "blue");
                    editor.apply();

                } else if (rbPurple.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("MyColorPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("colorfield", "purple");
                    editor.apply();

                }
                else {
                    SharedPreferences sp = getSharedPreferences("MyColorPreferences", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("colorfield", "green");
                    editor.apply();
                }
            }
        });
    }
}