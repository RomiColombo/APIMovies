package com.example.movieservice.controller;

import com.example.movieservice.model.Movie;
import com.example.movieservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<?> findAllMovies(){
        return ResponseEntity.ok().body(movieService.getAllMovies());
    }

    @GetMapping("/{genre}")
    public ResponseEntity<?> findAllByGenre(@PathVariable String genre){
        return ResponseEntity.ok().body(movieService.findByGenre(genre));
    }

    @PostMapping("/saveMovie")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie){
        return ResponseEntity.ok().body(movieService.saveMovie(movie));
    }
}