package com.example.VeersaGrp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDto {

    private Long user_id;
    private String name;
    private List<Long> client_ids;
    private List<Long> role_ids;
}
