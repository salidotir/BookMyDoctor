package com.example.bookmydoctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    FragmentTransaction transaction;

    Button btn_doctor_register;
    Button btn_user_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_doctor_register = findViewById(R.id.btn_doctor_register);
        btn_doctor_register.setOnClickListener(this);
        btn_user_register = findViewById(R.id.btn_user_register);
        btn_user_register.setOnClickListener(this);

        // set a new user_register_fragment on layout at first
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_fragment, new UserRegisterFragment());
        transaction.commit();

        btn_user_register.setBackgroundResource(R.drawable.login_signup_btn_selected_bg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_doctor_register:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment, new DoctorRegisterFragment());
                transaction.commit();

                btn_doctor_register.setBackgroundResource(R.drawable.login_signup_btn_selected_bg);
                btn_user_register.setBackgroundResource(R.drawable.login_signup_btn_bg);

                break;

            case R.id.btn_user_register:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_fragment, new UserRegisterFragment());
                transaction.commit();

                btn_doctor_register.setBackgroundResource(R.drawable.login_signup_btn_bg);
                btn_user_register.setBackgroundResource(R.drawable.login_signup_btn_selected_bg);

                break;
        }
    }
}
