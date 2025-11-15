package com.connecthub.app.models;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class CommentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    UserModel user;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    TopicModel topic;

    @Column(name = "comment")
    String comment;
}
