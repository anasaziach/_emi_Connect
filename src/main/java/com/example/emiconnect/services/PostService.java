package com.example.emiconnect.services;


import com.example.emiconnect.entity.Image;
import com.example.emiconnect.entity.Post;
import com.example.emiconnect.repositories.ImageRepository;
import com.example.emiconnect.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class PostService {
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    PostRepository postRepository;
    public void Post(MultipartFile file , String status) throws IOException {
        Image image = new Image(LocalDateTime.now(),file.getOriginalFilename());
        this.imageRepository.save(image);
        Post post = new Post(status,image);
        this.postRepository.save(post);

    }
    public Post test(){
        return this.postRepository.findById(100L).orElse(new Post());
    }
}
