package com.yogadarma.starwars.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yogadarma.starwars.R;

public class SplashScreenActivity extends AppCompatActivity {

    private Button btnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        btnMain = findViewById(R.id.btn_main);
        btnMain.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}