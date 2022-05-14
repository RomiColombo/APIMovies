package com.example.catalogservice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class CatalogWS {

    private String genre;
    private List<MovieWS> moviesws;
    private List<SerieWS> serieWS;

    public CatalogWS(String genre, List<MovieWS> moviesws, List<SerieWS> serieWS) {
        this.genre = genre;
        this.moviesws = moviesws;
        this.serieWS = serieWS;
    }

}