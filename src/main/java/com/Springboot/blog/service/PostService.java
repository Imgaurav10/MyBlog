package com.Springboot.blog.service;

import com.Springboot.blog.payload.PostDto;
import com.Springboot.blog.payload.PostResponse;

public interface PostService {
    PostDto savePost(PostDto postDto);

    PostDto getPostById(long id);

    PostResponse getAllPost(int pageNo, int pageSize, String sortBy, String sortDir);


    PostDto updatePostById(long id, PostDto postDto);

    void deletePostById(long id);
}
