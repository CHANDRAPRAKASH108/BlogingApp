package com.application.BlogingApp.Service;

import com.application.BlogingApp.Entity.Comment;
import com.application.BlogingApp.Payloads.CommentDto;
import com.application.BlogingApp.Payloads.CommentResponse;

import java.util.List;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto,Integer postId,Integer userId);
    List<CommentResponse> getAllComment();
    CommentResponse getCommentByPost(Integer commentId);
    void deleteComment(Integer commentId);
}
