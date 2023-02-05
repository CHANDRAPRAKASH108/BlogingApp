package com.application.BlogingApp.ServiceImplementation;
import com.application.BlogingApp.Entity.Category;
import com.application.BlogingApp.Entity.Post;
import com.application.BlogingApp.Entity.User;
import com.application.BlogingApp.Exceptions.ResourceNotFoundException;
import com.application.BlogingApp.Payloads.PostDto;
import com.application.BlogingApp.Repositories.CategoryRepository;
import com.application.BlogingApp.Repositories.PostRepository;
import com.application.BlogingApp.Repositories.UserRepository;
import com.application.BlogingApp.Service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostImplementation implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        Post post = this.modelMapper.map(postDto,Post.class);
        User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User ","Id",userId));
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category ","Id ",categoryId));
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post savePost = this.postRepository.save(post);
        return this.modelMapper.map(savePost,PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post ","Post With Id",postId));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName(postDto.getImageName());
        Post savePost = this.postRepository.save(post);
        return this.modelMapper.map(savePost,PostDto.class);
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category ","Category Id",categoryId));
        List<Post> postList = this.postRepository.findByCategory(category);
        return postList.stream().map(post -> this.modelMapper.map(post,PostDto.class)).toList();
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User ","User ID",userId));
        List<Post> postList = this.postRepository.findByUser(user);
        return postList.stream().map(post -> this.modelMapper.map(post,PostDto.class)).toList();
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> postList = this.postRepository.findAll();
        return postList.stream().map(post -> this.modelMapper.map(post,PostDto.class)).toList();
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post ","Post Id",postId));
        return this.modelMapper.map(post,PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post ","Post with Id",postId));
        this.postRepository.delete(post);
    }
}
