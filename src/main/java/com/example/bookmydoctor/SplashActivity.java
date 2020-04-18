package com.example.bookmydoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class SplashActivity extends AppCompatActivity {

    static int splash_timeout = 3000;

    Button btn_get_started;

    Animation zoom_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);

        btn_get_started = findViewById(R.id.btn_get_started);
        btn_get_started.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent splash_activity = new Intent(SplashActivity.this, LoginSignupActivity.class);
                startActivity(splash_activity);
                finish();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                btn_get_started.setVisibility(View.VISIBLE);
                btn_get_started.startAnimation(zoom_in);
            }
        }, splash_timeout);
    }
}
