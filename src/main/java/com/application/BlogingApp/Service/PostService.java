package com.application.BlogingApp.Service;

import com.application.BlogingApp.Payloads.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);
    PostDto updatePost(PostDto postDto, Integer postId);
    List<PostDto> getPostByCategory(Integer categoryId);
    List<PostDto> getPostByUser(Integer userId);
    List<PostDto> getAllPost();
    PostDto getPostById(Integer postId);
    void deletePost(Integer postId);
}
