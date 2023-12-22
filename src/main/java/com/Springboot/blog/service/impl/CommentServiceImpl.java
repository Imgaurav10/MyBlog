package com.Springboot.blog.service.impl;

import com.Springboot.blog.entity.Comment;
import com.Springboot.blog.entity.Post;
import com.Springboot.blog.exception.ResourceNotFoundException;
import com.Springboot.blog.payload.CommentDto;
import com.Springboot.blog.repository.CommentRepository;
import com.Springboot.blog.repository.PostRepository;
import com.Springboot.blog.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepo;
    private PostRepository postRepo;

    public CommentServiceImpl(CommentRepository commentRepo, PostRepository postRepo) {
        this.commentRepo = commentRepo;
        this.postRepo = postRepo;
    }

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        Post post = postRepo.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "postId", postId)
        );

        Comment comment = mapToEntity(commentDto);
        comment.setPost(post);
        Comment saved = commentRepo.save(comment);
        CommentDto dto = mapToDto(saved);
        return dto;
    }

    @Override
    public List<CommentDto> getAllCommentByPostId(long postId) {
        List<Comment> comments = commentRepo.findByPostId(postId);
        List<CommentDto> dtos = comments.stream().map(comment -> mapToDto(comment)).collect(Collectors.toList());
        return dtos;
    }

    Comment mapToEntity(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        return comment;
    }
    CommentDto mapToDto(Comment comment){
        CommentDto dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setName(comment.getName());
        dto.setEmail(comment.getEmail());
        dto.setBody(comment.getBody());
        return dto;
    }
}

