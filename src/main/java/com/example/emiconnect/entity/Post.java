package com.example.emiconnect.entity;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "POST_USER",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private User user;
    private LocalDateTime datePost = LocalDateTime.now();
    private String status;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "post_image",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    private List<Image> imageList = new ArrayList<>();
    private int NbComment;

    public Post() {
    }

    public Post(String status, Image image) {
        this.status = status;
        this.imageList.add(image);
    }

    public Post(User user, String status, Image image) {
        this.user = user;
        this.status = status;
        this.imageList.add(image);
    }

    public Post(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDatePost() {
        return datePost;
    }

    public void setDatePost(LocalDateTime datePost) {
        this.datePost = datePost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getNbComment() {
        return NbComment;
    }

    public void setNbComment(int nbComment) {
        NbComment = nbComment;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", user=" + user +
                ", datePost=" + datePost +
                ", status='" + status + '\'' +
                ", imageList=" + imageList +
                ", NbComment=" + NbComment +
                '}';
    }
}
