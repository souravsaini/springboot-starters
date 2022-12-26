package com.sourav.blogapp.payloads;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class PostResponse {
    private List<PostDTO> content;
    private Integer pageNumber;
    private Integer page;
    private Long totalRecords;
    private Integer totalPages;
    private Boolean lastPage;
}
