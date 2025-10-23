package com.connecthub.app.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rooms")
public class RoomModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }

    @Column
    String name;

    @Column
    String description;

    @Column
    @ManyToMany(cascade = CascadeType.ALL)
    List<UserModel> users;
}
