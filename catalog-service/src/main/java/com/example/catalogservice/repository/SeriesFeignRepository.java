package com.example.catalogservice.repository;

import com.example.catalogservice.model.dto.SerieWS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "series-service")
public interface SeriesFeignRepository {

    @GetMapping("/series/{genre}")
    List<SerieWS> getSeriesByGenre(@PathVariable String genre);

    @PostMapping("/series/save")
    SerieWS saveSerie(@RequestBody SerieWS serie);

    @GetMapping("/series/getAll")
    List<SerieWS> getSeries();

}
