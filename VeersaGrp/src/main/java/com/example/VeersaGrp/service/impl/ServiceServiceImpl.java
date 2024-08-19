package com.example.VeersaGrp.service.impl;

import com.example.VeersaGrp.dto.ServiceDto;
import com.example.VeersaGrp.mapper.ServiceMapper;
import com.example.VeersaGrp.model.Client;
import com.example.VeersaGrp.model.Program;
import com.example.VeersaGrp.model.Service;
import com.example.VeersaGrp.repository.ClientRepository;
import com.example.VeersaGrp.repository.ProgramRepository;
import com.example.VeersaGrp.repository.ServiceRepository;
import com.example.VeersaGrp.service.ServiceService;
import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    private ServiceRepository serviceRepository;
    private ProgramRepository programRepository;
    private ClientRepository clientRepository;

    @Override
    public ServiceDto registerService(ServiceDto serviceDto) {
        Service service = ServiceMapper.INSTANCE.toEntity(serviceDto);

//        if (serviceDto.getProgramIds() != null && !serviceDto.getProgramIds().isEmpty()) {
//            List<Program> programs = programRepository.findAllById(serviceDto.getProgramIds());
//            service.setPrograms(programs);
//        }
//
//        if (serviceDto.getClientIds() != null && !serviceDto.getClientIds().isEmpty()) {
//            Set<Client> clients = new HashSet<>(clientRepository.findAllById(serviceDto.getClientIds()));
//            service.setClients(clients);
//        }

        Service savedService = serviceRepository.save(service);

        ServiceDto savedServiceDto = ServiceMapper.INSTANCE.toDto(savedService);


        return savedServiceDto;
    }

    @Override
    public ServiceDto findService(Long serviceId) {
        Service service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return ServiceMapper.INSTANCE.toDto(service);
    }
}
