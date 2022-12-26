package com.sourav.blogapp.payloads;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@NoArgsConstructor
@Data
public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private String image;
    private Date date;
    private CategoryDTO category;
    private UserDTO user;


}
