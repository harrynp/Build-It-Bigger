package com.github.harrynp.jokejavalibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokeTeller {
    private List<String> jokes;

    public JokeTeller(){
        jokes = new ArrayList<>();
        jokes.add("Q: Why do programmers always mix up Halloween and Christmas? A: Because Oct 31 == Dec 25!");
        jokes.add("A SQL query goes into a bar, walks up to two tables and asks, Can I join you?");
        jokes.add("When your hammer is C++, everything begins to look like a thumb.");
    }

    public List<String> getJokes(){
        return jokes;
    }

    public String getRandomJoke(){
        Random random = new Random();
        return jokes.get(random.nextInt(jokes.size()));
    }
}
