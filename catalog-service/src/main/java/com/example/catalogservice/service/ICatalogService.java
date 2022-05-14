package com.example.catalogservice.service;

import com.example.catalogservice.model.Catalog;
import com.example.catalogservice.model.dto.MovieWS;
import com.example.catalogservice.model.dto.SerieWS;

public interface ICatalogService {

    Catalog getByGenre(String genre);
    Catalog saveMovie(MovieWS movieWS);
    Catalog saveSeries(SerieWS serieWS);

}