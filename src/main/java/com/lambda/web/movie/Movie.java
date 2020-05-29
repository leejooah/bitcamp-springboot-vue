package com.lambda.web.movie;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieSeq;
   @Column(length = 4)
    private String rank;
    @Column(length = 50)
    private String title;
    @Column(length = 10)
    private String rankDate;

    public Movie(){};

    public Movie( String title, String rank, String rankDate){ this.rankDate = rankDate; this.rank=rank; this.title = title;}

    public Long getMovieSeq() {
        return movieSeq;
    }

    public void setMovieSeq(Long movieSeq) {
        this.movieSeq = movieSeq;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRankDate() {
        return rankDate;
    }

    public void setRankDate(String rankDate) {
        this.rankDate = rankDate;
    }
}
