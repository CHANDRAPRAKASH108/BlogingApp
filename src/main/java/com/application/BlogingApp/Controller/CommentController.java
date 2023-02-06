package com.application.BlogingApp.Controller;
import com.application.BlogingApp.Payloads.ApiResponse;
import com.application.BlogingApp.Payloads.CommentDto;
import com.application.BlogingApp.Payloads.CommentResponse;
import com.application.BlogingApp.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/comment")
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;
    //add comment
    @PostMapping("/{postId}/{userId}")
    public ResponseEntity<CommentDto> addComment(
            @RequestBody CommentDto commentDto,
            @PathVariable String postId,
            @PathVariable String userId){
        CommentDto commentDto1 = this.commentService.createComment(commentDto,Integer.parseInt(postId),Integer.parseInt(userId));
        return new ResponseEntity<>(commentDto1, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<CommentResponse>> getAllComment(){
        List<CommentResponse> commentDtos = this.commentService.getAllComment();
        return new ResponseEntity<>(commentDtos,HttpStatus.OK);
    }
    @GetMapping("/{commentId}")
    public ResponseEntity<CommentResponse> getCommentById(@PathVariable String commentId){
        CommentResponse commentDto = this.commentService.getCommentByPost(Integer.parseInt(commentId));
        return new ResponseEntity<>(commentDto,HttpStatus.OK);
    }
    @DeleteMapping("/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable String commentId){
        this.commentService.deleteComment(Integer.parseInt(commentId));
        return new ResponseEntity<>(new ApiResponse("Comment Deleted Successfully",true),HttpStatus.OK);
    }
}
