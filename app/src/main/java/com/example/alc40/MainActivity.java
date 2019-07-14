package com.example.alc40;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAboutALC;
    Button myProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("ALC 4 Phase 1");

        setContentView(R.layout.activity_main);

        btnAboutALC = findViewById(R.id.btnAbout);
        myProfile = findViewById(R.id.btnMyProfile);


        btnAboutALC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent aboutALCActivity = new Intent(getApplicationContext(), AboutALC.class);
                startActivity(aboutALCActivity);
                finish();
            }
        });

        myProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myProfileActivity = new Intent(getApplicationContext(), MyProfile.class);
                startActivity(myProfileActivity);
                finish();
            }
        });


    }
}
