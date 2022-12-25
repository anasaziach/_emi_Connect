package com.example.emiconnect.repositories;

import com.example.emiconnect.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
