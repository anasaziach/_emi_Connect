package com.example.emiconnect.repositories;

import com.example.emiconnect.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comment,Long> {
    @Query("select c from Comment c  where c.post.id=:idPost")
    List<Comment> fetchAllCommentByIdPost(Long idPost);
}
