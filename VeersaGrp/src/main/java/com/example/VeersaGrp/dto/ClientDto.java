package com.example.VeersaGrp.dto;

import com.example.VeersaGrp.model.Program;
import com.example.VeersaGrp.model.Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private Long clientId;

    private String name;

    private Set<ServiceDto> services ;
    private List<ProgramDto> programs;


}
