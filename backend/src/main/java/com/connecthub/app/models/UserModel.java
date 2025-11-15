package com.connecthub.app.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String username;

    @Column
    String password;

    @Column
    String email;

    @Column
    Integer age;

    @Column
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "users")
    List<RoomModel> rooms;

    @Column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    List<TopicModel> topics;

    @Column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    List<CommentModel> comments;

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
