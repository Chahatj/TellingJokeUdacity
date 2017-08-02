package com.chahat.jokedisplaylibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        TextView textViewJoke = (TextView) findViewById(R.id.textViewJoke);

        Intent intent = getIntent();
        if (intent!=null){
            if (intent.hasExtra(Intent.EXTRA_TEXT)){
                String joke = intent.getStringExtra(Intent.EXTRA_TEXT);
                textViewJoke.setText(joke);
            }
        }
    }
}
