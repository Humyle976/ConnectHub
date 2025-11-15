package com.connecthub.app.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rooms")
public class RoomModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String name;

    @Column
    String description;

    @Column
    @ManyToMany(cascade = CascadeType.ALL)
    List<UserModel> users;

    @Column
    @OneToMany(mappedBy = "room")
    List<TopicModel> topics;

}
