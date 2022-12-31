package com.example.emiconnect.repositories;

import com.example.emiconnect.entity.Comment;
import com.example.emiconnect.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
}
