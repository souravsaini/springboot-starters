package com.sourav.blogapp.payloads;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CategoryDTO {
    private Long id;
    @NotEmpty
    private String title;
    private String description;
}
