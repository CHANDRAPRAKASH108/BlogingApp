package com.application.BlogingApp.Controller;
import com.application.BlogingApp.Config.Constants;
import com.application.BlogingApp.Payloads.ApiResponse;
import com.application.BlogingApp.Payloads.PostDto;
import com.application.BlogingApp.Payloads.PostResponse;
import com.application.BlogingApp.Service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostService postService;
    //create post
    @PostMapping("/user/{userId}/category/{categoryId}/post")
    public ResponseEntity<PostDto> createPost(
            @Valid
            @RequestBody PostDto postDto,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId){
        PostDto postDto1 = this.postService.createPost(postDto,userId,categoryId);
        return new ResponseEntity<>(postDto1, HttpStatus.CREATED);
    }

    //get post by category
    @GetMapping("/post/category/{categoryId}")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId){
        List<PostDto> postDto = this.postService.getPostByCategory(categoryId);
        return new ResponseEntity<>(postDto,HttpStatus.OK);
    }

    //get post by category
    @GetMapping("/post/user/{userId}")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
        List<PostDto> postDto = this.postService.getPostByUser(userId);
        return new ResponseEntity<>(postDto,HttpStatus.OK);
    }

    //get all post
    @GetMapping("/post")
    public ResponseEntity<PostResponse> getAllPost(
            @RequestParam(value = "pageNumber",defaultValue = Constants.PAGE_NUMBER,required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = Constants.PAGE_SIZE,required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = Constants.SORT_BY,required = false) String sortBy ){
        PostResponse postDtoList = this.postService.getAllPost(pageNumber,pageSize,sortBy);
        return new ResponseEntity<>(postDtoList,HttpStatus.OK);
    }
    // get post by id
    @GetMapping("/post/{postId}")
    public ResponseEntity<PostDto> getPost(@PathVariable Integer postId){
        PostDto postDto = this.postService.getPostById(postId);
        return new ResponseEntity<>(postDto,HttpStatus.OK);
    }

    //delete post
    @DeleteMapping("/post/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId){
        this.postService.deletePost(postId);
        return new ResponseEntity<>(new ApiResponse("Post Deleted Successfully",true),HttpStatus.OK);
    }

    //update post
    @PutMapping("/post/{postId}")
    public ResponseEntity<PostDto> updatePost(
            @RequestBody PostDto postDto,
            @PathVariable Integer postId){
        PostDto postDto1= this.postService.updatePost(postDto,postId);
        return new ResponseEntity<>(postDto1,HttpStatus.OK);
    }

    //post search by title
    @GetMapping("/post/search/{title}")
    public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable String title){
        List<PostDto> postDto = this.postService.searchByTitle(title);
        return new ResponseEntity<>(postDto,HttpStatus.OK);
    }
}
