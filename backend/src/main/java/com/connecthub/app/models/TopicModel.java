package com.connecthub.app.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "topics")
public class TopicModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    RoomModel room;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserModel user;

    @Column(name = "description")
    String desc;

    @Column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "topic")
    List<CommentModel> comments;



}
