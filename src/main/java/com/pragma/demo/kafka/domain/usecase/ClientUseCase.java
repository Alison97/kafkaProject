package com.pragma.demo.kafka.domain.usecase;

import com.pragma.demo.kafka.domain.api.IClientServicePort;
import com.pragma.demo.kafka.domain.model.ClientModel;
import com.pragma.demo.kafka.domain.spi.IClientPersistencePort;

public class ClientUseCase implements IClientServicePort {

    private final IClientPersistencePort clientPersistencePort;

    public ClientUseCase(IClientPersistencePort clientPersistencePort) {
        this.clientPersistencePort = clientPersistencePort;
    }


    @Override
    public void saveClient(ClientModel clientModel) {
        clientPersistencePort.save(clientModel);
    }
}
