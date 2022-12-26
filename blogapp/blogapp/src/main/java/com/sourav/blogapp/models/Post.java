package com.sourav.blogapp.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "posts")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String content;
    private String image;
    @Column(nullable = false)
    private Date date;
    @ManyToOne()
    private Category category;
    @ManyToOne
    private User user;


}
