package com.example.VeersaGrp.service;

import com.example.VeersaGrp.dto.AddUserDto;
import com.example.VeersaGrp.dto.UpdateUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface UserService {

    ResponseEntity<?> user_add(AddUserDto userReq);
    ResponseEntity<?> get_role(Long user_id);
    ResponseEntity<?> get_client(Long user_id);
    ResponseEntity<?> delete_user(Long user_id);
    ResponseEntity<?> update_user(UpdateUserDto userReq);
}
