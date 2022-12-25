package com.example.emiconnect.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime datePost = LocalDateTime.now();
    private String status;
    @OneToMany
    @JoinTable(name = "MY_JOIN_TABLE",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    private List<Image> imageList = new ArrayList<>();

    public Post() {
    }

    public Post(String status, Image image) {
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

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", datePost=" + datePost +
                ", status='" + status + '\'' +
                ", imageList=" + imageList +
                '}';
    }
}
