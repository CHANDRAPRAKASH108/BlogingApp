package com.application.BlogingApp.Payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CommentResponse {
    private int id;
    private String content;
    private PostDto post;

}
