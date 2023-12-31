package com.Springboot.blog.service;

import com.Springboot.blog.payload.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> getAllCommentByPostId(long postId);

    CommentDto getCommentById(long postId, long commentId);
}
