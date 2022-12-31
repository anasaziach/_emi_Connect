package com.example.emiconnect.controller;


import com.example.emiconnect.entity.Discussion;
import com.example.emiconnect.entity.RequestChat;
import com.example.emiconnect.entity.User;
import com.example.emiconnect.repositories.DiscussionRepository;
import com.example.emiconnect.repositories.UserRepository;
import com.example.emiconnect.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class ChatController {
    @Autowired
    ChatService chatService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    DiscussionRepository discussionRepository;

    @PostMapping(path = "/api/sendMessage")
    public String sendMessage(@RequestBody RequestChat chat){
//        System.out.println(this.chatService.sendMessage(chat.getIdSrc(),chat.getIdDest(),chat.getMessage()));
        return this.chatService.sendMessage(chat.getIdSrc(),chat.getIdDest(),chat.getMessage());
    }
    @GetMapping(path = "api/fetchDiscByIdUser")
    public List<Discussion> fetchDiscByIdUserr(Long idUser){
        return this.chatService.fetchDiscByIdUserr(idUser);
    }
    @GetMapping("api/fetchContact")
    public List<User> fetchContact(@RequestParam("idUser") Long idUser){
        return this.chatService.fetchContact(idUser);
    }
    @GetMapping(path = "/api/test")
    public Discussion test(){
        //return this.discussionRepository.checkExistDisc(1L,2L);
        return this.discussionRepository.fetchDiscByIdUser(1L).get(0);
    }
}
