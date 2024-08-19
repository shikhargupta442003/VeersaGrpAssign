package com.example.VeersaGrp.dto;

import com.example.VeersaGrp.model.Client;
import com.example.VeersaGrp.model.Service;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProgramDto {

    private Long programId;


    private String name;

    private ClientDto client;

    private Set<ServiceDto> services;
}
