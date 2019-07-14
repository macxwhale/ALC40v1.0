package com.example.alc40;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPageAdapter IntroViewPageAdapter;
    TabLayout tabIndicator;
    Button btnNext;
    int position = 0;
    Button btnGetStarted;
    Animation btnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Make activity full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // When this activity is about to be launched we need to check if its opened before or not
        if (restorePrefData()) {
            Intent mainActivity = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(mainActivity);
            finish();
        }

        setContentView(R.layout.activity_intro);

        // Hide the action bar

        getSupportActionBar().hide();

        //Ini views
        btnNext = findViewById(R.id.btnNext);
        btnGetStarted = findViewById(R.id.btnGetStarted);
        tabIndicator = findViewById(R.id.tabIndicator);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);

        // Fill list screen
        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Introduction", "We’re excited to announce the launch of Andela Learning Community 4.0 in partnership with Google and Pluralsight n partnership with Google and Pluralsight. The program will run for a period of 6 months starting from today 15th May 2019.  ", R.drawable.img1));
        mList.add(new ScreenItem("Objective", "Google and Pluralsight are companies that share our commitment to scale technology talent and learning across Africa, and we’re happy to partner with them ALC 4.0 will bring Andela closer to achieving its bold mission of training 100,000 software engineers across Africa in 10 years.", R.drawable.img2));
        mList.add(new ScreenItem("Andela Learning Community", "The Andela Learning Community is open to everyone interested in acquiring technical skills, regardless of their educational background. For this current track, participants will be advancing their skills in  Web development, Android development and Google Cloud technologies on Pluralsight. Learners who successfully complete the Google Scholarship Certification Program have the opportunity to go a step further to take a Google Certification exam, thereby certifying their competence and job readiness.", R.drawable.img3));

        // Setup view pager
        screenPager = findViewById(R.id.screenViewPager);
        IntroViewPageAdapter = new IntroViewPageAdapter(this,mList);
        screenPager.setAdapter(IntroViewPageAdapter);

        //Setup tablayout with viewpager

        tabIndicator.setupWithViewPager(screenPager);

        //Next button click listener
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = screenPager.getCurrentItem();
                if (position < mList.size()) {
                    position++;
                    screenPager.setCurrentItem(position);
                }
                if (position == mList.size()-1) {
                    //When we reach to the last screen
                    // TODO : Show the GET STARTED button and hide the indicator and the next button
                    loadLastScreen();
                }

            }
        });

        // tabLayout add change listener

        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size()-1) {
                    loadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // Get started button click listener
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // open Main activity
                Intent mainActivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainActivity);

                // Save boolean value to storage so next time when user runs the app
                // We could know that he is already checked the into screen activity
                // Using shared preferences

                savePrefsData();
                finish();

            }
        });
    }

    private boolean restorePrefData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        Boolean isIntroActivityOpenBefore = pref.getBoolean("isIntroOpened", false);
        return isIntroActivityOpenBefore;
    }

    private void savePrefsData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences( "myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpened", true);
        editor.apply();
    }

    // Show the GET STARTED button and hide the indicator and the next button
    private void loadLastScreen() {
        btnNext.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.VISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);

        // TODO: add an animation to get started button
        // setup animation
        btnGetStarted.setAnimation(btnAnim);
    }
}
