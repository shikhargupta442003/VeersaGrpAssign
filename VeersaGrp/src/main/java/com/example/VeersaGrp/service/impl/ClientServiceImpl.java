package com.example.VeersaGrp.service.impl;

import com.example.VeersaGrp.dto.ClientDto;
import com.example.VeersaGrp.mapper.ClientMapper;
import com.example.VeersaGrp.model.Client;
import com.example.VeersaGrp.repository.ClientRepository;
import com.example.VeersaGrp.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Override
    public ClientDto registerClient(ClientDto clientDto) {
        Client client = ClientMapper.INSTANCE.toEntity(clientDto);
        Client savedClient = clientRepository.save(client);
        return ClientMapper.INSTANCE.toDto(savedClient);
    }

    @Override
    public ClientDto findClient(Long clientId) {
        Client client =clientRepository.findById(clientId)
                        .orElseThrow(() -> new RuntimeException("Client not found"));
        return ClientMapper.INSTANCE.toDto(client);
    }
}
