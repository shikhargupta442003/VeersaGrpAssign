package com.example.VeersaGrp.service;


import com.example.VeersaGrp.dto.RoleDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface    RoleService {

    ResponseEntity<?> role_add(String name);
    ResponseEntity<?> role_delete(Long id);
    ResponseEntity<?>  role_update(RoleDto roleReq);
}
