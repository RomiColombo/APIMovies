package com.example.catalogservice.model;

import com.example.catalogservice.model.dto.MovieWS;
import com.example.catalogservice.model.dto.SerieWS;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Catalog {

    @Id
    private String id;
    private String genre;
    private List<MovieWS> moviesws;
    private List<SerieWS> serieWS;

    public Catalog(String genre, List<MovieWS> moviesws, List<SerieWS> serieWS) {
        this.genre = genre;
        this.moviesws = moviesws;
        this.serieWS = serieWS;
    }
}
