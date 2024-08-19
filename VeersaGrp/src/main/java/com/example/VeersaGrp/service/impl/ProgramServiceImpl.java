package com.example.VeersaGrp.service.impl;

import com.example.VeersaGrp.dto.ProgramDto;
import com.example.VeersaGrp.mapper.ProgramMapper;
import com.example.VeersaGrp.model.Program;
import com.example.VeersaGrp.repository.ProgramRepository;
import com.example.VeersaGrp.repository.ServiceRepository;
import com.example.VeersaGrp.service.ProgramService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProgramServiceImpl implements ProgramService {

    ProgramRepository programRepository;
    ServiceRepository serviceRepository;

    @Override
    public ProgramDto registerProgram(ProgramDto programDto, List<Long> serviceIds) {
        Program program = ProgramMapper.INSTANCE.toEntity(programDto);
        for(Long serviceId:serviceIds){
            com.example.VeersaGrp.model.Service service= serviceRepository.getReferenceById(serviceId);

        }
    }

    @Override
    public ProgramDto findProgram(Long programId) {
        return null;
    }
}
