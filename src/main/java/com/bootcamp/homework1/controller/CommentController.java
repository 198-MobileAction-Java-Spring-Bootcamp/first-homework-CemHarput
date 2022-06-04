package com.bootcamp.homework1.controller;

import com.bootcamp.homework1.entity.Comment;
import com.bootcamp.homework1.entity.User;
import com.bootcamp.homework1.repo.CommentRepo;
import com.bootcamp.homework1.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentRepo commentRepo;


    @GetMapping
    public ResponseEntity<List<Comment>> getAllUsers(){

        List<Comment> commentList = commentRepo.findAll();

        return ResponseEntity.ok(commentList);
    }


    @PostMapping
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment){

        comment = commentRepo.save(comment);

        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable int id){
        return commentRepo.deleteById(id);
    }


    @PutMapping
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment){

        if (comment.getId() == null){
            throw new RuntimeException("Comment id cannot be empty!");
        }

        boolean isExist = commentRepo.existsById(comment.getId());
        if (!isExist){
            throw new RuntimeException("Comment does not exist!");
        }

        comment = commentRepo.save(comment);

        return ResponseEntity.ok(comment);
    }
}
