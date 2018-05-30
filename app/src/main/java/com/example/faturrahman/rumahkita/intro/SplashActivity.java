package com.example.faturrahman.rumahkita.intro;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.faturrahman.rumahkita.R;
import com.example.faturrahman.rumahkita.utils.FirebaseUtils;
import com.example.faturrahman.rumahkita.login.signin.LoginActivity;
import com.example.faturrahman.rumahkita.main.MainActivity2;
import com.google.firebase.auth.FirebaseAuth;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initActivity();
    }

    private void initActivity() {
        final FirebaseAuth firebaseAuth = FirebaseUtils.getFirebaseAuth();

        //check if user is already logged in or not. if not, navigate to login, if yes, navigate to main activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(firebaseAuth.getCurrentUser() != null)
                    navigateToMain();
                else navigateToLogin();
            }
        }, 2000);
    }

    private void navigateToLogin() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    private void navigateToMain() {
        startActivity(new Intent(this, MainActivity2.class));
    }
}
