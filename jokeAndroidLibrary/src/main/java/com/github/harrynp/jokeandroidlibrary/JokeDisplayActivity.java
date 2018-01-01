package com.github.harrynp.jokeandroidlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    public static final String INTENT_JOKE = "JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        String joke = getIntent().getStringExtra(INTENT_JOKE);
        getSupportActionBar().setTitle("Random Joke");
        TextView jokeTextView = findViewById(R.id.tv_joke);
        if (joke != null && !joke.isEmpty()) {
            jokeTextView.setText(joke);
        } else {
            jokeTextView.setText(getString(R.string.error_message));
        }
    }
}
