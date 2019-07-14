package com.example.alc40;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class AboutALC extends AppCompatActivity {

    private static final String URL = "https://andela.com/alc/";

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent backHome = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(backHome, 0);
        return true;
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        WebView aboutALC = findViewById(R.id.wvAboutALC);

        aboutALC.loadUrl(URL);




    }

}
