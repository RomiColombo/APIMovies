package com.example.catalogservice.service;

import com.example.catalogservice.model.dto.MovieWS;
import com.example.catalogservice.repository.MovieFeignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieFeignRepository movieFeignRepository;

    @Autowired
    public MovieService(MovieFeignRepository movieFeignRepository) {
        this.movieFeignRepository = movieFeignRepository;
    }

    public List<MovieWS> getAllMovies(){
        return movieFeignRepository.getMovies();
    }

    public List<MovieWS> getAllByGenre(String genre){
        return movieFeignRepository.getMoviesByGenre(genre);
    }

    public MovieWS saveMovie(MovieWS movieWS){
        return movieFeignRepository.saveMovie(movieWS);
    }


}
