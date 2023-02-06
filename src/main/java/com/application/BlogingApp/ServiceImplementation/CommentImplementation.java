package com.application.BlogingApp.ServiceImplementation;
import com.application.BlogingApp.Entity.Comment;
import com.application.BlogingApp.Entity.Post;
import com.application.BlogingApp.Entity.User;
import com.application.BlogingApp.Exceptions.ResourceNotFoundException;
import com.application.BlogingApp.Payloads.CommentDto;
import com.application.BlogingApp.Payloads.CommentResponse;
import com.application.BlogingApp.Repositories.CommentRepository;
import com.application.BlogingApp.Repositories.PostRepository;
import com.application.BlogingApp.Repositories.UserRepository;
import com.application.BlogingApp.Service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentImplementation implements CommentService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId,Integer userId) {
        Comment comment=this.modelMapper.map(commentDto,Comment.class);
        Post post = this.postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","Post with Id",postId));
        User user = this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","User with Id",userId));
        comment.setPost(post);
        comment.setUser(user);
        Comment addComment = this.commentRepository.save(comment);
        return this.modelMapper.map(addComment,CommentDto.class);
    }

    @Override
    public List<CommentResponse> getAllComment() {
        List<Comment> comment = this.commentRepository.findAll();
        return comment.stream().map(comment1 -> this.modelMapper.map(comment1, CommentResponse.class)).toList();
    }

    @Override
    public CommentResponse getCommentByPost(Integer commentId) {
        Comment comment = this.commentRepository.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment","Comment with id",commentId));
        return this.modelMapper.map(comment,CommentResponse.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = this.commentRepository.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment","Comment with Id",commentId));
        this.commentRepository.delete(comment);
    }
}
