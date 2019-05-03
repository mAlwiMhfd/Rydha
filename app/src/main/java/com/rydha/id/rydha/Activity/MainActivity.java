package com.rydha.id.rydha.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rydha.id.rydha.Adapter.ActivityAdapter;
import com.rydha.id.rydha.Adapter.SlidingImageAdapter;
import com.rydha.id.rydha.LoginActivity;
import com.rydha.id.rydha.Model.Activity;
import com.rydha.id.rydha.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button btnhh;
    private List<Activity> activitys=new ArrayList<>();
    RecyclerView lstActivity;
    LinearLayoutManager linear;

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES= {R.drawable.programsatu,R.drawable.programyatim,R.drawable.programzakat};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    private FirebaseAuth mAuth;
    FirebaseUser fUser;
    GoogleApiClient mGoogle;
    GoogleSignInClient mGoogleSignInClient ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstActivity=(RecyclerView)findViewById(R.id.lstAct);
        linear=new LinearLayoutManager(this);
        lstActivity.setLayoutManager(linear);

        mAuth=FirebaseAuth.getInstance();
        fUser=mAuth.getCurrentUser();


        activitys.add(new Activity(R.mipmap.donasi,"Donasi"));
        activitys.add(new Activity(R.mipmap.agenda,"Program Kami"));
        activitys.add(new Activity(R.mipmap.kalkulator,"Kalkulator Zakat"));
        activitys.add(new Activity(R.mipmap.akun,"Kontak"));
        btnhh=(Button)findViewById(R.id.btnhh);
        btnhh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(getString(R.string.default_web_client_id))
//                .requestEmail()
//                .build();
//        mGoogleSignInClient = GoogleSignIn.getClient(getApplicationContext(), gso);
//
//                mAuth.signOut();
//                mGoogleSignInClient.signOut();
//                Intent i=new Intent(MainActivity.this, LoginActivity.class);
//                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(i);
//                finish();
                sendToLogin();
                finish();
            }
       });

        ActivityAdapter adapter=new ActivityAdapter(activitys);
        lstActivity.setAdapter(adapter);

        init();
    }

    private void init() {
        for(int i=0;i<IMAGES.length;i++)
            ImagesArray.add(IMAGES[i]);

        mPager = (ViewPager) findViewById(R.id.pager);


        mPager.setAdapter(new SlidingImageAdapter(MainActivity.this,ImagesArray));


        NUM_PAGES =IMAGES.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

    }
    private void sendToLogin() {
        GoogleSignInClient mGoogleSignInClient ;
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(getApplicationContext(), gso);
        mGoogleSignInClient.signOut().addOnCompleteListener(this,
                new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        FirebaseAuth.getInstance().signOut();
                        Intent setupIntent = new Intent(getApplicationContext(), LoginActivity.class);
                        Toast.makeText(getBaseContext(), "Logged Out", Toast.LENGTH_LONG).show(); //if u want to show some text
                        setupIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        setupIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(setupIntent);
                        finish();
                    }
                });
    }

}
