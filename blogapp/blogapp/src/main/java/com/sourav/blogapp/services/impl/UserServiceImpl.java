package com.sourav.blogapp.services.impl;

import com.sourav.blogapp.exceptions.ResourceNotFoundException;
import com.sourav.blogapp.models.User;
import com.sourav.blogapp.payloads.UserDTO;
import com.sourav.blogapp.repositories.UserRepository;
import com.sourav.blogapp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private ModelMapper modelMapper;
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = this.userDTOtoUser(userDTO);
        User savedUser = userRepository.save(user);
        return this.userToUserDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setAbout(userDTO.getAbout());
        User updatedUser = userRepository.save(user);
        return this.userToUserDTO(updatedUser);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return this.userToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = users.stream().map(user -> this.userToUserDTO(user)).collect(Collectors.toList());
        return userDTOS;
    }

    @Override
    public boolean deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.delete(user);
        return true;
    }

    private User userDTOtoUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
//        user.setId(userDTO.getId());
//        user.setName(userDTO.getName());
//        user.setPassword(userDTO.getPassword());
//        user.setEmail(userDTO.getEmail());
//        user.setAbout(userDTO.getAbout());
        return user;
    }

    private UserDTO userToUserDTO(User user) {
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }
}
