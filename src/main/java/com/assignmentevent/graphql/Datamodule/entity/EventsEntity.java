package com.assignmentevent.graphql.Datamodule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class EventsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;
    private String eventName;
    private String location;
    private String organizer;
    private int numberOfAttendees;
    private String dateTime;
    private int duration;
    @ManyToOne
    @JoinColumn(name="u_id")
        private UsersEntity usersEntity;

}
