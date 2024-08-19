package com.example.VeersaGrp.controller;

import com.example.VeersaGrp.dto.ServiceDto;
import com.example.VeersaGrp.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class ServiceController {

    ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService){
        this.serviceService=serviceService;
    }

    @PostMapping()
    public ResponseEntity<ServiceDto> registerService(@RequestBody ServiceDto serviceDto){
        ServiceDto result=serviceService.registerService(serviceDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping({"serviceId"})
    public ResponseEntity<ServiceDto> findService(@PathVariable Long serviceId){
        ServiceDto result=serviceService.findService(serviceId);
        return new ResponseEntity<>(result,HttpStatus.FOUND);
    }
}
