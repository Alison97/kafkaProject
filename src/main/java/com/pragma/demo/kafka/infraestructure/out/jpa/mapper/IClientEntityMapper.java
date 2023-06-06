package com.pragma.demo.kafka.infraestructure.out.jpa.mapper;


import com.pragma.demo.kafka.domain.model.ClientModel;
import com.pragma.demo.kafka.infraestructure.out.jpa.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IClientEntityMapper {

    ClientEntity toEntity(ClientModel client);
    ClientModel toClientModel(ClientEntity clientEntity);

}
