package com.example.seriesservice.service;

import com.example.seriesservice.model.Serie;

import java.util.List;

public interface ISerieService {

    List<Serie> getAllSeries();
    List<Serie> findByGenre(String genre);
    Serie saveSerie(Serie serie);
    void deleteAll();

}