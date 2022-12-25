package com.example.emiconnect.repositories;

import com.example.emiconnect.entity.Discussion;
import com.example.emiconnect.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Repository
public interface DiscussionRepository extends JpaRepository<Discussion,Long> {
    @Query("select q from Discussion q join q.users u where u.id=:idUser")
    List<Discussion> fetchDiscByIdUser(@RequestParam("idUser") Long idUser);
    @Query("select q from Discussion q join q.users u where q in (select t from Discussion t join t.users u where u.id=:senderId) and u.id=:receiverId")
    Discussion checkExistDisc(Long senderId , Long receiverId);
}
