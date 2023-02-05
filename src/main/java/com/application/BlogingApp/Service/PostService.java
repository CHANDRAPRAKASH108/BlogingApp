package com.application.BlogingApp.Service;

import com.application.BlogingApp.Payloads.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);

    PostDto updateUser(PostDto postDto, Integer postId);
}
