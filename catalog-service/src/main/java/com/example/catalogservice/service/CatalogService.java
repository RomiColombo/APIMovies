package com.example.catalogservice.service;

import com.example.catalogservice.model.Catalog;
import com.example.catalogservice.model.dto.CatalogWS;
import com.example.catalogservice.model.dto.MovieWS;
import com.example.catalogservice.model.dto.SerieWS;
import com.example.catalogservice.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService implements ICatalogService{

    private final CatalogRepository catalogRepository;
    private final MovieService movieService;
    private final SeriesService seriesService;

    @Autowired
    public CatalogService(CatalogRepository catalogRepository, MovieService movieService, SeriesService seriesService) {
        this.catalogRepository = catalogRepository;
        this.movieService = movieService;
        this.seriesService = seriesService;
    }


    @Override
    public Catalog getByGenre(String genre) {

        List<MovieWS> movieWSList = movieService.getAllByGenre(genre);
        List<SerieWS> serieWSList = seriesService.getSeriesByGenre(genre);

        Catalog catalog = new Catalog(genre, movieWSList, serieWSList);
        Catalog oldCatalog = catalogRepository.findByGenre(genre).orElse(null);

        //Aca controla si hay peliculas / series en la bdd de catalogo con ese genero
        if (oldCatalog != null){
            catalogRepository.deleteByGenre(genre);
        }
        catalogRepository.save(catalog);

        return catalog;
    }

    @Override
    public Catalog saveMovie(MovieWS movieWS) {

        Catalog catalog = catalogRepository.findByGenre(movieWS.getGenre()).get();
        catalog.getMoviesws().add(movieWS);

        return catalogRepository.save(catalog);
    }

    @Override
    public Catalog saveSeries(SerieWS serieWS) {

        Catalog catalog = catalogRepository.findByGenre(serieWS.getGenre()).get();
        catalog.getSerieWS().add(serieWS);

        return catalogRepository.save(catalog);
    }

}