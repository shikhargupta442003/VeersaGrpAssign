package com.example.VeersaGrp.mapper;

import com.example.VeersaGrp.dto.ClientDto;
import com.example.VeersaGrp.dto.ProgramDto;
import com.example.VeersaGrp.dto.ServiceDto;
import com.example.VeersaGrp.model.Client;
import com.example.VeersaGrp.model.Program;
import com.example.VeersaGrp.model.Service;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(target = "programs", ignore = true)
    @Mapping(target = "services", ignore = true)
    Client toEntity(ClientDto clientDto);

    @Mapping(target = "programs", ignore = true)
    @Mapping(target = "services", ignore = true)
    ClientDto toDto(Client client);

    // If you have mappers for Program and Service entities:
    @Mapping(target = "programs", source = "programs")
    @Mapping(target = "services", source = "services")
    ClientDto toDtoWithRelations(Client client, List<ProgramDto> programs, Set<ServiceDto> services);

    @Mapping(target = "programs", source = "programs")
    @Mapping(target = "services", source = "services")
    Client toEntityWithRelations(ClientDto clientDto, List<Program> programs, Set<Service> services);
}
