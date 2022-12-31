package com.example.emiconnect.entity;


import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @ManyToOne
    @JoinTable(name = "COMMENTS_USER",
            joinColumns = @JoinColumn(name = "comment_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    private Post post;
    public Comment() {
    }

    public Comment(User user , String content , Post post) {
        this.content = content;
        this.user = user;
        this.post=post;
    }

    public Comment(User user) {
        this.user = user;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }
}
