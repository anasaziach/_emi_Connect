package com.example.emiconnect.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "STORY_USER",
            joinColumns = @JoinColumn(name = "story_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private User user;
    private LocalDateTime dateStory = LocalDateTime.now();
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "story_image",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    private List<Image> imageList = new ArrayList<>();
    private int NbSee = 0;//number of uers who see the story
    public Story() {
    }

    public Story(User user, Image image) {
        this.user = user;
        this.imageList.add(image);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDateStory() {
        return dateStory;
    }

    public void setDateStory(LocalDateTime dateStory) {
        this.dateStory = dateStory;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public int getNbSee() {
        return NbSee;
    }

    public void setNbSee(int nbSee) {
        NbSee = nbSee;
    }

    @Override
    public String toString() {
        return "Story{" +
                "id=" + id +
                ", user=" + user +
                ", dateStory=" + dateStory +
                ", imageList=" + imageList +
                ", NbSee=" + NbSee +
                '}';
    }
}
