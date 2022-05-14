package com.example.seriesservice.controller;

import com.example.seriesservice.model.Serie;
import com.example.seriesservice.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/series")
public class SerieController {

    private final SerieService serieService;

    @Autowired
    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping
    public ResponseEntity<?> findAllSeries(){
        return ResponseEntity.ok().body(serieService.getAllSeries());
    }

    @GetMapping("/{genre}")
    public ResponseEntity<?> findAllByGenre(@PathVariable String genre){
        return ResponseEntity.ok().body(serieService.findByGenre(genre));
    }

    @PostMapping("/saveSerie")
    public ResponseEntity<Serie> saveSerie(@RequestBody Serie serie){
        return ResponseEntity.ok().body(serieService.saveSerie(serie));
    }
}