package com.sourav.blogapp.repositories;

import com.sourav.blogapp.models.Category;
import com.sourav.blogapp.models.Post;
import com.sourav.blogapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
    List<Post> findByTitleContaining(String title);
}
