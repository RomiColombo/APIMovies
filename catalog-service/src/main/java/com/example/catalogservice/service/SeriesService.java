package com.example.catalogservice.service;

import com.example.catalogservice.model.dto.SerieWS;
import com.example.catalogservice.repository.SeriesFeignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesService {

    private final SeriesFeignRepository seriesFeignRepository;

    @Autowired
    public SeriesService(SeriesFeignRepository seriesFeignRepository) {
        this.seriesFeignRepository = seriesFeignRepository;
    }

    public List<SerieWS> getAllSeries(){
        return seriesFeignRepository.getSeries();
    }

    public List<SerieWS> getSeriesByGenre(String genre){
        return  seriesFeignRepository.getSeriesByGenre(genre);
    }

    public SerieWS createSeries(SerieWS serieWS){
        return  seriesFeignRepository.saveSerie(serieWS);
    }

}