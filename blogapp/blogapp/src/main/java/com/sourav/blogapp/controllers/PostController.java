package com.sourav.blogapp.controllers;

import com.sourav.blogapp.configs.AppConstants;
import com.sourav.blogapp.payloads.PostDTO;
import com.sourav.blogapp.payloads.PostResponse;
import com.sourav.blogapp.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO, @PathVariable(name = "userId") Long userId,
                                              @PathVariable(name = "categoryId") Long categoryId) {
        PostDTO post = postService.createPost(postDTO, userId, categoryId);
        return new ResponseEntity<PostDTO>(post,HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDTO>> getPostsByUser(@PathVariable(name = "userId") Long id) {
        List<PostDTO> posts = postService.getPostsByUser(id);
        return new ResponseEntity<List<PostDTO>>(posts, HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDTO>> getPostsByCategory(@PathVariable(name = "categoryId") Long id) {
        List<PostDTO> posts = postService.getPostsByCategory(id);
        return new ResponseEntity<List<PostDTO>>(posts, HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam (name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "page", defaultValue = AppConstants.PAGE, required = false) Integer page,
            @RequestParam(name = "sortBy", defaultValue = "title", required = false) String sortBy,
            @RequestParam(name = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir
            ) {
        PostResponse posts = postService.getAllPosts(pageSize, page, sortBy, sortDir);
        return new ResponseEntity<PostResponse>(posts, HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable(name = "postId") Long id) {
        PostDTO post = postService.getPost(id);
        return new ResponseEntity<PostDTO>(post, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<Boolean> deletePost(@PathVariable(name = "postId") Long id) {
        boolean isDeleted = postService.deletePost(id);
        return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO, @PathVariable(name = "postId") Long id) {
        PostDTO updatedPost = postService.updatePost(postDTO, id);
        return new ResponseEntity<PostDTO>(updatedPost, HttpStatus.OK);
    }

    @GetMapping("/posts/search/{keyword}")
    public ResponseEntity<List<PostDTO>> searchPostsByTitle(@PathVariable("keyword") String keyword) {
        List<PostDTO> posts = postService.searchPosts(keyword);
        return new ResponseEntity<List<PostDTO>>(posts, HttpStatus.OK);
    }
}
