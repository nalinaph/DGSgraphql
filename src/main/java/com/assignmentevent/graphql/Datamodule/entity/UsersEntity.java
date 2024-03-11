package com.assignmentevent.graphql.Datamodule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
import java.util.UUID;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custId;
    private String firstName;
    private String secondName;
    @OneToMany(mappedBy = "usersEntity", cascade = CascadeType.ALL)
    private List<EventsEntity> events;


}
