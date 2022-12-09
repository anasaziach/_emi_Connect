package com.example.emiconnect;

import com.example.emiconnect.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Post,Long> {
}
