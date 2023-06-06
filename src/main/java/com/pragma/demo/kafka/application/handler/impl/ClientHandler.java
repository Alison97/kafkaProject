package com.pragma.demo.kafka.application.handler.impl;

import com.pragma.demo.kafka.application.dto.request.ClientRequestDTO;
import com.pragma.demo.kafka.application.handler.IClientHandler;
import com.pragma.demo.kafka.application.mapper.IClientRequestMapper;
import com.pragma.demo.kafka.domain.api.IClientServicePort;
import org.springframework.stereotype.Component;

@Component
public class ClientHandler implements IClientHandler {

    private final IClientServicePort clientServicePort;
    private final IClientRequestMapper clientRequestMapper;

    public ClientHandler(IClientServicePort clientServicePort, IClientRequestMapper clientRequestMapper) {
        this.clientServicePort = clientServicePort;
        this.clientRequestMapper = clientRequestMapper;
    }


    @Override
    public void saveClient(ClientRequestDTO clientRequestDTO) {
        clientServicePort.saveClient(clientRequestMapper.toModel(clientRequestDTO));
    }
}
