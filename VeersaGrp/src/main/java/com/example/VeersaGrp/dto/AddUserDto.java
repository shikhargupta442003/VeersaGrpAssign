package com.example.VeersaGrp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserDto {


    private String name;
    private List<Long> client_ids;
    private List<Long> role_ids;
}
