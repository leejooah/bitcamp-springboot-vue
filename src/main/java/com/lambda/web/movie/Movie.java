package com.lambda.web.movie;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieNo;

    @Column(length = 50)
    private String title;

    public Movie(){};

    public Movie( String title){ this.title = title;}

    public Long getMovieNo() {
        return movieNo;
    }

    public void setMovieNo(Long movieNo) {
        this.movieNo = movieNo;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
