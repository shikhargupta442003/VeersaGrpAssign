package com.example.VeersaGrp.service.impl;

import com.example.VeersaGrp.dto.RoleDto;
import com.example.VeersaGrp.model.Role;
import com.example.VeersaGrp.repository.RoleRepository;
import com.example.VeersaGrp.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepo;

    public RoleServiceImpl(RoleRepository roleRepo) {
        this.roleRepo = roleRepo;
    }


    @Override
    public ResponseEntity<?> role_add(String name) {
        try {
            Role role = new Role();
            role.setName(name);
            roleRepo.save(role);
            return ResponseEntity.ok("Role added successfully");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> role_delete(Long id) {
        try {
            Optional<Role> roleOpt = roleRepo.findById(id);

            if(roleOpt.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Role does not exist with id: "+ id);
            }

            roleRepo.delete(roleOpt.get());
            return ResponseEntity.ok("Role Deleted successfully");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> role_update(RoleDto roleReq) {
        try {
            Optional<Role> roleOpt = roleRepo.findById(roleReq.getId());

            if(roleOpt.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Role does not exist with id: "+ roleReq.getId());
            }
            Role role = roleOpt.get();
            role.setName(roleReq.getName());
            roleRepo.save(role);
            return ResponseEntity.ok("Role Updated successfully");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
