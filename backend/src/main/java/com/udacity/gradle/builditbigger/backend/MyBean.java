package com.udacity.gradle.builditbigger.backend;

import com.github.harrynp.jokejavalibrary.JokeTeller;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public MyBean(){
    }

    public String getJoke(){
        return new JokeTeller().getRandomJoke();
    }

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }
}