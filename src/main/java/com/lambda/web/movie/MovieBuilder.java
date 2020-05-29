package com.lambda.web.movie;

public class MovieBuilder {
    private String title;
    private String rank;
    private String rankDate;

    public MovieBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public MovieBuilder setRank(String rank) {
        this.rank = rank;
        return this;
    }

    public MovieBuilder setRankDate(String rankDate) {
        this.rankDate = rankDate;
        return this;
    }

    public Movie createMovie() {
        return new Movie(title, rank, rankDate);
    }
}