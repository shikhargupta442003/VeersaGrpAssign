package com.example.VeersaGrp.controller;

import com.example.VeersaGrp.dto.ClientDto;
import com.example.VeersaGrp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService=clientService;
    }

    @PostMapping
    public ResponseEntity<ClientDto> registerClient(@RequestBody ClientDto clientDto){
        ClientDto result= clientService.registerClient(clientDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("{clientId}")
    public ResponseEntity<ClientDto> findClient(@PathVariable Long clientId ){
        ClientDto
    }


}
