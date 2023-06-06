package com.pragma.demo.kafka.domain.api;

import com.pragma.demo.kafka.domain.model.ClientModel;

public interface IClientServicePort {

    void saveClient(ClientModel clientModel);

}
