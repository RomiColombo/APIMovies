package com.example.catalogservice.repository;

import com.example.catalogservice.model.dto.MovieWS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="movie-service")
public interface MovieFeignRepository {

    @GetMapping("/movies/{genre}")
    List<MovieWS> getMoviesByGenre(@PathVariable String genre);

    @PostMapping("/movies/save")
    MovieWS saveMovie(@RequestBody MovieWS movie);

    @GetMapping("/movies/getAll")
    List<MovieWS> getMovies();
}
