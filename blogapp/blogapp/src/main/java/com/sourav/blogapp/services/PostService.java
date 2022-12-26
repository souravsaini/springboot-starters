package com.sourav.blogapp.services;

import com.sourav.blogapp.models.Post;
import com.sourav.blogapp.payloads.PostDTO;
import com.sourav.blogapp.payloads.PostResponse;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO, Long userId, Long categoryId);
    PostDTO updatePost(PostDTO postDTO, Long id);
    boolean deletePost(Long id);
    PostResponse getAllPosts(Integer pageSize, Integer page, String sortBy, String sortDir);

    PostDTO getPost(Long id);

    List<PostDTO> getPostsByCategory(Long id);

    List<PostDTO> getPostsByUser(Long id);

    List<PostDTO> searchPosts(String keyword);
}
