package com.example.VeersaGrp.controller;


import com.example.VeersaGrp.model.Program;
import com.example.VeersaGrp.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/program")
public class ProgramController {

    ProgramService programService;

    @Autowired
    public ProgramController(ProgramService programService){
        this.programService=programService;
    }

    @PostMapping()
    public ResponseEntity<Program>
}
