package com.example.VeersaGrp.repository;

import com.example.VeersaGrp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
//    List<User> findDistinctByClientList_CIdAndRoleList_RId(int cId, int rId);
}

