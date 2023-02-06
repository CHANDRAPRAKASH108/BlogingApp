package com.application.BlogingApp.Payloads;

import com.application.BlogingApp.Entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentDto {
    private int id;
    private String content;
    private PostDto post;
    private UserDto user;
}
