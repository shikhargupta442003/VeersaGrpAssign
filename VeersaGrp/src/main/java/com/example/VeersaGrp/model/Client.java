package com.example.VeersaGrp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "public")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long clientId;


    private String name;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Program> programs= new ArrayList<>();

    @ManyToMany(mappedBy = "clients",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Service> services =new HashSet<>();


    @ManyToMany(mappedBy = "clientList", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private Set<User> userList = new HashSet<>();
}
