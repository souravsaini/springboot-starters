package com.sourav.blogapp.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserDTO {
    private Long id;
    @NotEmpty
    @Size(min = 4, message = "name must be minimum of 4 characters")
    private String name;
    @Email(message = "invalid email address")
    private String email;
    @NotEmpty
    @Size(min = 6, message = "password too short")
    private String password;
    @NotEmpty
    private String about;
}
