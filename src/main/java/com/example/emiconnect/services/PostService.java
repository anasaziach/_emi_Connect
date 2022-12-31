package com.example.emiconnect.services;


import com.example.emiconnect.entity.*;
import com.example.emiconnect.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CommentsRepository commentsRepository;
    @Autowired
    StoryRepository storyRepository;
    public void Post(String path , String status,Long idUser) throws IOException {
        Image image = new Image(LocalDateTime.now(),path);
        this.imageRepository.save(image);
        User user = this.userRepository.findById(idUser)
                .orElseThrow(()->new RuntimeException("user with this post not found!"));
        Post post = new Post(user,status,image);
        this.postRepository.save(post);

    }
    public void addStory(String path , Long idUser) throws IOException {
        Image image = new Image(LocalDateTime.now(),path);
        this.imageRepository.save(image);
        User user = this.userRepository.findById(idUser)
                .orElseThrow(()->new RuntimeException("user with this story not found!"));
        Story story = new Story(user,image);
        this.storyRepository.save(story);

    }
    public void addComment(Long idPost , Long idUser , String comment){
        Post post = this.postRepository.findById(idPost)
                .orElseThrow(()->new RuntimeException("post not found!"));
        User user = this.userRepository.findById(idUser)
                .orElseThrow(()->new RuntimeException("user who comment not found!"));
        Comment comment1 = new Comment(user,comment,post);
        this.commentsRepository.save(comment1);
        post.setNbComment(post.getNbComment()+1);
        this.postRepository.save(post);
    }
    public List<Story> fetchAllStories(){
        return this.storyRepository.findAll();
    }

    public List<Comment> fetchAllCommentByIdPost(Long idPost){
        return this.commentsRepository.fetchAllCommentByIdPost(idPost);
    }

    public List<Post> fetchAllPost(){
        return this.postRepository.findAll();
    }
    public Post test(){
        return this.postRepository.findById(100L).orElse(new Post());
    }
}
