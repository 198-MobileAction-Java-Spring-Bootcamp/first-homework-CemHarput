package com.bootcamp.homework1.repo;

import com.bootcamp.homework1.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Long> {
    String deleteById(int id);
}
