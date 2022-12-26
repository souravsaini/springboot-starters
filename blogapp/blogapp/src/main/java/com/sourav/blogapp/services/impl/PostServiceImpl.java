package com.sourav.blogapp.services.impl;

import com.sourav.blogapp.exceptions.ResourceNotFoundException;
import com.sourav.blogapp.models.Category;
import com.sourav.blogapp.models.Post;
import com.sourav.blogapp.models.User;
import com.sourav.blogapp.payloads.PostDTO;
import com.sourav.blogapp.payloads.PostResponse;
import com.sourav.blogapp.repositories.CategoryRepository;
import com.sourav.blogapp.repositories.PostRepository;
import com.sourav.blogapp.repositories.UserRepository;
import com.sourav.blogapp.services.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private ModelMapper modelMapper;
    @Override
    public PostDTO createPost(PostDTO postDTO, Long userId, Long categoryId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        Post post = modelMapper.map(postDTO, Post.class);
        post.setImage("default.png");
        post.setDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        postRepository.save(post);
        return modelMapper.map(post, PostDTO.class);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        Post updatedPost = postRepository.save(post);
        return modelMapper.map(updatedPost, PostDTO.class);
    }

    @Override
    public boolean deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
        return true;
    }

    @Override
    public PostResponse getAllPosts(Integer pageSize, Integer page, String sortBy, String sortDir) {
        //Pagination and Sorting
        Sort sort = null;
        if(sortDir.equalsIgnoreCase("asc")) {
            sort = Sort.by(sortBy).ascending();
        } else if(sortDir.equalsIgnoreCase("desc")) {
            sort = Sort.by(sortBy).descending();
        }
        Pageable p = PageRequest.of(pageSize, page, sort);
        Page<Post> pagePosts = postRepository.findAll(p);
        List<Post> posts = pagePosts.getContent();
        List<PostDTO> postDTOS = posts.stream().map(post -> modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDTOS);
        postResponse.setPageNumber(pagePosts.getNumber());
        postResponse.setPage(pagePosts.getSize());
        postResponse.setTotalRecords(pagePosts.getTotalElements());
        postResponse.setTotalPages(pagePosts.getTotalPages());
        postResponse.setLastPage(pagePosts.isLast());

        return postResponse;
    }

    @Override
    public PostDTO getPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return modelMapper.map(post, PostDTO.class);
    }

    @Override
    public List<PostDTO> getPostsByCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
        List<Post> posts = postRepository.findByCategory(category);
        List<PostDTO> postDTOS = posts.stream().map(post -> modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
        return postDTOS;
    }

    @Override
    public List<PostDTO> getPostsByUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        List<Post> posts = postRepository.findByUser(user);
        List<PostDTO> postDTOS = posts.stream().map(post -> modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
        return postDTOS;
    }

    @Override
    public List<PostDTO> searchPosts(String keyword) {
        List<Post> posts= postRepository.findByTitleContaining(keyword);
        List<PostDTO> postDTOS = posts.stream().map(post -> modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
        return postDTOS;
    }
}
