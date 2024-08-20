package com.example.VeersaGrp.controller;


import com.example.VeersaGrp.dto.RoleDto;
import com.example.VeersaGrp.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @PostMapping
    public ResponseEntity<?> AddRole(@RequestParam String name){
        return roleService.role_add(name);
    }


    @DeleteMapping
    public ResponseEntity<?> DeleteRole(@RequestParam Long id) {
        return roleService.role_delete(id);
    }

    @PatchMapping
    public ResponseEntity<?> updateRole(@RequestBody RoleDto roleReq) {
        return roleService.role_update(roleReq);
    }
}
