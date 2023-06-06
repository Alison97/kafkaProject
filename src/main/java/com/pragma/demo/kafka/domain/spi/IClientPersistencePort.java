package com.pragma.demo.kafka.domain.spi;

import com.pragma.demo.kafka.domain.model.ClientModel;

public interface IClientPersistencePort {

    ClientModel save(ClientModel clientModel);
}
