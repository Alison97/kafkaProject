package com.pragma.demo.kafka.infraestructure.input.kafka.listener;

import com.pragma.demo.kafka.application.dto.request.ClientRequestDTO;
import com.pragma.demo.kafka.application.handler.IClientHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;



@Component
public class ClientConsumer {

    private final IClientHandler clientHandler;

    private static final String topic = "create.client.v1";
    private final Logger logger = LoggerFactory.getLogger(ClientConsumer.class);

    public ClientConsumer(IClientHandler clientHandler) {
        this.clientHandler = clientHandler;
    }


    @KafkaListener(topics = topic, containerFactory = "config.kafka.client.consumerFactory")
    public void save(ClientRequestDTO clientRequestDTO) {
        clientHandler.saveClient(clientRequestDTO);
    }
}
