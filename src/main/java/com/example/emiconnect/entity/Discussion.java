package com.example.emiconnect.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "participants",
            joinColumns = @JoinColumn(name = "disc_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users = new ArrayList<>();
    private String room;

    public Discussion() {
    }

    public Discussion(Long id, List<User> users, String room) {
        this.id = id;
        this.users = users;
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User u){
        this.users.add(u);
    }

    @Override
    public String toString() {
        return "Discussion{" +
                "id=" + id +
                ", users=" + users +
                ", room='" + room + '\'' +
                '}';
    }
}
