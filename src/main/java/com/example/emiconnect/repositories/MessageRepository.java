package com.example.emiconnect.repositories;

import com.example.emiconnect.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long> {
    @Query("select m from Message m where m.receiver.id=:idUser or m.sender.id=:idUser")
    List<Message> fetchDiscByIdUser(Long idUser);
}
