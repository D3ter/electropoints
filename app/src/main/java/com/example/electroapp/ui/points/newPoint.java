package com.example.electroapp.ui.points;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.electroapp.R;

public class newPoint extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_point);

        this.setTitle("Crear punto");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}