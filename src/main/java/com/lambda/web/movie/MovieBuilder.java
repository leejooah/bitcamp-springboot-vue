package com.lambda.web.movie;

public class MovieBuilder {
    private String title;



    public MovieBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public Movie createMovie() {
        return new Movie(title);
    }
}