package com.example.bookmydoctor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginSignupActivity extends AppCompatActivity {

    TextView text_view_create_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);

        text_view_create_account = findViewById(R.id.text_view_create_account);
        text_view_create_account.setClickable(true);
        text_view_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // got to activity register.
                Intent intent = new Intent(LoginSignupActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}
