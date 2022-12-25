package com.example.emiconnect.controller;


import com.example.emiconnect.services.PostService;
import com.example.emiconnect.storage.StorageService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class PostController {
    @Autowired
    StorageService storageService;
    @Autowired
    PostService postService;
    @PostMapping("/post")
    public void post(MultipartFile file ,String status) throws IOException {
        if(this.storageService.store(file)) this.postService.Post(file,status);
    }

    @PostMapping("/testo")
    private String testo(@RequestBody String test){
        JSONObject obj = new JSONObject();
        String testt = test.split("\"")[1];
        System.out.println(testt);
        obj.put("st",testt);
        return obj.toString();
    }
}
