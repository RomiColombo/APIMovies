package com.example.movieservice.service;

import com.example.movieservice.model.Movie;

import java.util.List;

public interface IMovieService {

    List<Movie> getAllMovies();
    List<Movie> findByGenre(String genre);
    Movie saveMovie(Movie movie);
    void deleteAll();
}
