package com.example.catalogservice.service.queue;

import com.example.catalogservice.model.dto.SerieWS;
import com.example.catalogservice.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SerieListener {

    private final CatalogService catalogService;

    @RabbitListener(queues = {"${queue.serie.name}"})
    public void receive(@Payload SerieWS serieWS){
        catalogService.saveSeries(serieWS);
    }
}
