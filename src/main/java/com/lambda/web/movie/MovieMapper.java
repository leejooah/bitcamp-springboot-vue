package com.lambda.web.movie;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieMapper {
    public void insertMovie(MovieDTO movieDTO);
    public void updateMovie(MovieDTO movieDTO);
    public void deleteMovie(MovieDTO movieDTO);
    public List<MovieDTO> seleteMovies();
    public MovieDTO seleteMovie();
    public int countMovies();
}
