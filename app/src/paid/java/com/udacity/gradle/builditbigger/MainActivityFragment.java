package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.github.harrynp.jokeandroidlibrary.JokeDisplayActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements JokeListener {
    private RelativeLayout mRelativeLayout;
    private ProgressBar mProgressBar;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        mRelativeLayout = root.findViewById(R.id.rl_main);
        mProgressBar = root.findViewById(R.id.pb_loading_indicator);
        Button button = root.findViewById(R.id.tell_joke_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoading();
                getJoke();
            }
        });
        return root;
    }


    private void showMainWindow(){
        mProgressBar.setVisibility(View.INVISIBLE);
        mRelativeLayout.setVisibility(View.VISIBLE);
    }

    private void showLoading(){
        mProgressBar.setVisibility(View.VISIBLE);
        mRelativeLayout.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onJokeReceived(String joke) {
        showMainWindow();
        Intent intent = new Intent(getActivity(), JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.INTENT_JOKE, joke);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void getJoke(){
        new EndpointsAsyncTask().execute(this);
    }
}
