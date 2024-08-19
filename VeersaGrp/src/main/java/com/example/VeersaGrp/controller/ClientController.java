package com.example.VeersaGrp.controller;

import com.example.VeersaGrp.dto.ClientDto;
import com.example.VeersaGrp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService=clientService;
    }

    @PostMapping("")
    public ResponseEntity<ClientDto> registerClient(@RequestBody ClientDto clientDto){
        ClientDto result= clientService.registerClient(clientDto);
        if(result.equals("Client registered successfully")){
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
        }
    }
}
