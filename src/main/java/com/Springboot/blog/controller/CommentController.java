package com.Springboot.blog.controller;

import com.Springboot.blog.payload.CommentDto;
import com.Springboot.blog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestParam("postId")long postId,
                                                    @RequestBody CommentDto commentDto){
        CommentDto dto=commentService.createComment(postId,commentDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<List<CommentDto>> getAllCommentByPostId(@PathVariable("postId") long postId){
       List<CommentDto> list= commentService.getAllCommentByPostId(postId);
       return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable("commentId") long commentId,
                                                     @PathVariable("postId") long postId){
        CommentDto dto=commentService.getCommentById(postId,commentId);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
