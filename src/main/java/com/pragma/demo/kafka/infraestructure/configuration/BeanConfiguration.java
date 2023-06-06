package com.pragma.demo.kafka.infraestructure.configuration;

import com.pragma.demo.kafka.domain.api.IClientServicePort;
import com.pragma.demo.kafka.domain.spi.IClientPersistencePort;
import com.pragma.demo.kafka.domain.usecase.ClientUseCase;
import com.pragma.demo.kafka.infraestructure.out.jpa.adapter.ClientJpaAdapter;
import com.pragma.demo.kafka.infraestructure.out.jpa.mapper.IClientEntityMapper;
import com.pragma.demo.kafka.infraestructure.out.jpa.repository.IClientRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {


    private final IClientRepository clientRepository;
    private final IClientEntityMapper clientEntityMapper;

    public BeanConfiguration(IClientRepository clientRepository, IClientEntityMapper clientEntityMapper) {
        this.clientRepository = clientRepository;
        this.clientEntityMapper = clientEntityMapper;
    }


    @Bean
    public IClientPersistencePort clientPersistencePort() {
        return new ClientJpaAdapter(clientRepository,clientEntityMapper);
    }

    @Bean
    public IClientServicePort clientServicePort() {
        return new ClientUseCase(clientPersistencePort());
    }



}
