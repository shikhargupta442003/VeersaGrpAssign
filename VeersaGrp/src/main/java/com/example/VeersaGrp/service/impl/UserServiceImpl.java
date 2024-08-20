package com.example.VeersaGrp.service.impl;


import com.example.VeersaGrp.dto.AddUserDto;
import com.example.VeersaGrp.dto.UpdateUserDto;
import com.example.VeersaGrp.model.Client;
import com.example.VeersaGrp.model.Role;
import com.example.VeersaGrp.model.User;
import com.example.VeersaGrp.repository.ClientRepository;
import com.example.VeersaGrp.repository.RoleRepository;
import com.example.VeersaGrp.repository.UserRepository;
import com.example.VeersaGrp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;


@Component
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final ClientRepository clientRepo;
    private final RoleRepository roleRepo;

    public UserServiceImpl(UserRepository userRepo, ClientRepository clientRepo, RoleRepository roleRepo) {
        this.userRepo = userRepo;
        this.clientRepo = clientRepo;
        this.roleRepo = roleRepo;
    }

    @Override
    public ResponseEntity<?> user_add(AddUserDto userReq) {
        try {
            User user = new User();
            user.setName(userReq.getName());

            for (Long clientId : userReq.getClient_ids()) {
                Optional<Client> client = clientRepo.findById(clientId);
                if (client.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body("Client Id " + clientId + " is not valid.");
                }
                user.getClientList().add(client.get());
            }

            for (Long roleId : userReq.getRole_ids()) {
                Optional<Role> role = roleRepo.findById(roleId);
                if (role.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body("Role Id " + roleId + " is not valid.");
                }
                user.getRoleList().add(role.get());
            }

            userRepo.save(user);
            return ResponseEntity.ok("User added successfully");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> get_role(Long user_id) {
        try {
            Optional<User> user = userRepo.findById(user_id);
            if(user.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exist with id: "+ user_id);
            }

            return ResponseEntity.ok(user.get().getRoleList());
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @Override
    public ResponseEntity<?> get_client(Long user_id) {
        try {
            Optional<User> user = userRepo.findById(user_id);
            if(user.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exist with id: "+ user_id);
            }

            return ResponseEntity.ok(user.get().getClientList());
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> delete_user(Long user_id) {
        try {
            Optional<User> user = userRepo.findById(user_id);
            if(user.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exist with id: "+ user_id);
            }

            userRepo.delete(user.get());
            return ResponseEntity.ok("User Deleted successfully with id: "+ user_id);
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    public ResponseEntity<?> update_user(UpdateUserDto userReq) {
        try {
            Optional<User> userOpt = userRepo.findById(userReq.getUser_id());
            if (userOpt.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exist with id: " + userReq.getUser_id());
            }

            User user = userOpt.get();

            if (userReq.getName() != null) {
                user.setName(userReq.getName());
            }
            Set<Role> existingRoles = user.getRoleList();
            if (userReq.getRole_ids() != null && !userReq.getRole_ids().isEmpty()) {
                for (Long roleId : userReq.getRole_ids()) {
                    Optional<Role> roleOpt = roleRepo.findById(roleId);
                    roleOpt.ifPresent(existingRoles::add);
                }
            }

            Set<Client> existingClient = user.getClientList();
            if (userReq.getClient_ids() != null && !userReq.getClient_ids().isEmpty()) {
                for (Long clientId : userReq.getClient_ids()) {
                    Optional<Client> clientOpt = clientRepo.findById(clientId);
                    clientOpt.ifPresent(existingClient::add);
                }
            }
            userRepo.save(user);
            return ResponseEntity.ok("User updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }



}
