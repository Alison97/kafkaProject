package com.pragma.demo.kafka.application.handler;

import com.pragma.demo.kafka.application.dto.request.ClientRequestDTO;

public interface IClientHandler {

    void saveClient(ClientRequestDTO clientRequestDTO);
}
