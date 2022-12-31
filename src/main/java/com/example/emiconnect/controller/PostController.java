package com.example.emiconnect.controller;


import com.example.emiconnect.entity.*;
import com.example.emiconnect.repositories.PostRepository;
import com.example.emiconnect.services.PostService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    private PostRepository postRepository;

    @PostMapping("/post")
    public void post(@RequestBody PostModel postModel) throws IOException {
        System.out.println(postModel);
        this.postService.Post(postModel.getPath(),postModel.getStatus(),postModel.getIdUser());
    }
    @PostMapping("/api/addStory")
    public void addStory(@RequestBody StoryModel storyModel) throws IOException {
        System.out.println(storyModel);
        this.postService.addStory(storyModel.getPath(),storyModel.getIdUser());
    }
    @PostMapping("api/commentApost")
    public void addComment(@RequestBody CommentModal data){
        this.postService.addComment(data.getIdPost(),data.getIdUser(),data.getComment());
    }

    @PostMapping("/testo")
    private String testo(@RequestBody String test){
        JSONObject obj = new JSONObject();
        String testt = test.split("\"")[1];
        System.out.println(testt);
        obj.put("st",testt);
        return obj.toString();
    }
    @GetMapping("/api/fetchDataHome")
    public List<Post> fetchAllPost(){
        return this.postService.fetchAllPost();
    }
    @GetMapping("api/fetchAllCommentsByIdPost")
    public List<Comment> fetchAllCommentByIdPost(Long idPost){
        return this.postService.fetchAllCommentByIdPost(idPost);
    }
    @GetMapping("/api/fetchAllStories")
    public List<Story> fetchAllStories(){
        return this.postService.fetchAllStories();
    }
    @GetMapping(
            value = "/get-image-with-media-type",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody byte[] getImageWithMediaType() throws IOException {
        return  getClass().getResourceAsStream("com/example/emiconnect/upload-dir/test3.jpg").readAllBytes();
    }
}
