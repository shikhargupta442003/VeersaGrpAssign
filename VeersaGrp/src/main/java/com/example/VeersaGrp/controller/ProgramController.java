package com.example.VeersaGrp.controller;


import com.example.VeersaGrp.dto.ProgramDto;
import com.example.VeersaGrp.model.Program;
import com.example.VeersaGrp.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/program")
public class ProgramController {

    ProgramService programService;

    @Autowired
    public ProgramController(ProgramService programService){
        this.programService=programService;
    }

    @PostMapping("{clientId}")
    public ResponseEntity<ProgramDto> registerProgram(@RequestBody ProgramDto programDto, @RequestParam List<Long> serviceIds ){
        ProgramDto result=programService.registerProgram(programDto,serviceIds);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("{programId}")
    public ResponseEntity<ProgramDto> findProgram(@PathVariable Long programId){
        ProgramDto result=programService.findProgram(programId);
        return new ResponseEntity<>(result,HttpStatus.FOUND);
    }
}
