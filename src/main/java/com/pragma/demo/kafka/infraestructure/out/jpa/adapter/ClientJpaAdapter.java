package com.pragma.demo.kafka.infraestructure.out.jpa.adapter;

import com.pragma.demo.kafka.domain.model.ClientModel;
import com.pragma.demo.kafka.domain.spi.IClientPersistencePort;
import com.pragma.demo.kafka.infraestructure.out.jpa.entity.ClientEntity;
import com.pragma.demo.kafka.infraestructure.out.jpa.mapper.IClientEntityMapper;
import com.pragma.demo.kafka.infraestructure.out.jpa.repository.IClientRepository;

public class ClientJpaAdapter implements IClientPersistencePort {

    private final IClientRepository clientRepository;
    private final IClientEntityMapper clientEntityMapper;

    public ClientJpaAdapter(IClientRepository clientRepository, IClientEntityMapper clientEntityMapper) {
        this.clientRepository = clientRepository;
        this.clientEntityMapper = clientEntityMapper;
    }

    @Override
    public ClientModel save(ClientModel clientModel) {
        ClientEntity clientEntity = clientRepository.save(clientEntityMapper.toEntity(clientModel));
        return clientEntityMapper.toClientModel(clientEntity);
    }
}
