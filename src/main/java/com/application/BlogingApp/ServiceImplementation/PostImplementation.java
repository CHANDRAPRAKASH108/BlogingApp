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
    public PostDto updateUser(PostDto postDto, Integer postId) {
        return null;
    }
}
