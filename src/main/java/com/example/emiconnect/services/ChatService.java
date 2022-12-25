package com.example.emiconnect.services;


import com.example.emiconnect.entity.Discussion;
import com.example.emiconnect.entity.Message;
import com.example.emiconnect.entity.User;
import com.example.emiconnect.repositories.DiscussionRepository;
import com.example.emiconnect.repositories.MessageRepository;
import com.example.emiconnect.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService implements CommandLineRunner {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    DiscussionRepository discussionRepository;
    public User checkExistUser(Long idUser , String role){
         return this.userRepository.findById(idUser)
                .orElseThrow(()->{
                    throw new RuntimeException(role+" not found!");
                });
    }
    public List<Discussion> fetchDiscByIdUserr(Long idUser){
        checkExistUser(idUser,"user");
        return this.discussionRepository.fetchDiscByIdUser(idUser);
    }

    public String sendMessage(Long idSrc , Long idDest , String message) throws RuntimeException {
        User sender = checkExistUser(idSrc,"sender");
        User receiver = checkExistUser(idDest,"receiver");
        Discussion discussion = this.discussionRepository.checkExistDisc(idSrc,idDest);
        if(discussion==null) {
            discussion = new Discussion();
            discussion.addUser(sender);
            discussion.addUser(receiver);
            this.discussionRepository.save(discussion); // i dont know if id is given to the discussion before it's saved on db or in the moment of saving it
            discussion.setRoom("user"+idSrc+""+idDest);
            this.discussionRepository.save(discussion);
        }
        this.messageRepository.save(new Message(sender,receiver,message));
        return discussion.getRoom();
    }
    public List<User> fetchContact(Long id){
        return this.userRepository
                .findAll()
                .stream()
                .filter(x->x.getId()!=id)
                .toList();
    }


    @Override
    public void run(String... args) throws Exception {
        /*this.userRepository.save(new User("anas1"));
        this.userRepository.save(new User("anas2"));
        this.userRepository.save(new User("anas3"));*/
    }
}
