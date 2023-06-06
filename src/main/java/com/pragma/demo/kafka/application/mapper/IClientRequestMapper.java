package com.pragma.demo.kafka.application.mapper;

import com.pragma.demo.kafka.application.dto.request.ClientRequestDTO;
import com.pragma.demo.kafka.domain.model.ClientModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IClientRequestMapper {

    ClientModel toModel(ClientRequestDTO clientRequestDTO);
}
