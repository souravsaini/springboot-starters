package com.sourav.blogapp.services;

import com.sourav.blogapp.payloads.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO user);

    UserDTO updateUser(UserDTO user, Long id);

    UserDTO getUserById(Long id);

    List<UserDTO> getAllUsers();

    boolean deleteUser(Long id);
}
