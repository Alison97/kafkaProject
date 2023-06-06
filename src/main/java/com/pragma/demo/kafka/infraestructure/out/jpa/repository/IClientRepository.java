package com.pragma.demo.kafka.infraestructure.out.jpa.repository;

import com.pragma.demo.kafka.infraestructure.out.jpa.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IClientRepository extends JpaRepository<ClientEntity, UUID> {
}
