package com.example.VeersaGrp.mapper;

import com.example.VeersaGrp.dto.ServiceDto;
import com.example.VeersaGrp.model.Service;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ProgramMapper.class, ClientMapper.class})
public interface ServiceMapper {

    ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);

    @Mapping(target = "programs", source = "programs")
    @Mapping(target = "clients", source = "clients")
    Service toEntity(ServiceDto serviceDto);

    @Mapping(target = "programs", source = "programs")
    @Mapping(target = "clients", source = "clients")
    ServiceDto toDto(Service service);
}
