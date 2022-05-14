package com.example.catalogservice.service.queue;

import com.example.catalogservice.model.dto.MovieWS;
import com.example.catalogservice.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieListener {

    private final CatalogService catalogService;

    @RabbitListener(queues = {"${queue.movie.name}"})
    public void receive(@Payload MovieWS movieWS){
        //log.info("Se guardo una pelicula en el catologo de "+ movie.getGenre());
        catalogService.saveMovie(movieWS);
    }
}
