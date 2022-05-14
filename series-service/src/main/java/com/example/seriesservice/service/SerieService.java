package com.example.seriesservice.service;

import com.example.seriesservice.model.Serie;
import com.example.seriesservice.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService implements ISerieService{

    public final SerieRepository serieRepository;

    @Autowired
    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }


    @Override
    public List<Serie> getAllSeries() {
        return serieRepository.findAll();
    }

    @Override
    public List<Serie> findByGenre(String genre) {
        return serieRepository.findAllByGenre(genre);
    }

    @Override
    public Serie saveSerie(Serie serie) {
        return serieRepository.save(serie);
    }

    @Override
    public void deleteAll() {
        serieRepository.deleteAll();
    }
}