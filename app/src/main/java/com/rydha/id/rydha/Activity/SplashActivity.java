package com.rydha.id.rydha.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rydha.id.rydha.LoginActivity;
import com.rydha.id.rydha.R;

/**
 * Created by ole on 10/1/18.
 */

public class SplashActivity extends AppCompatActivity {

    private static final int DTK=1500;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        countDown();
    }

    private void countDown(){
        Handler handler = new Handler();
        Runnable tunggu = new Runnable() {
            @Override
            public void run() {
                gotoMain();
            }
        };
        handler.postDelayed(tunggu, DTK);
    }

    private void gotoMain(){
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();

        if (firebaseUser !=null){
            Intent i=new Intent(this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
            finish();
        }else {
            Intent l=new Intent(this, LoginActivity.class);
            startActivity(l);
            finish();
        }

    }
}
