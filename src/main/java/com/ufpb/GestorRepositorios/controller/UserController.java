package com.ufpb.GestorRepositorios.controller;

import com.ufpb.GestorRepositorios.dto.UserDTO;
import com.ufpb.GestorRepositorios.mappers.UserMapper;
import com.ufpb.GestorRepositorios.models.User;
import com.ufpb.GestorRepositorios.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;
    private UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping(path = "/users")
    public List<User>  getUsers() {
       return this.userService.listUsers();
    }

    @GetMapping(path = "/users/{userId}")
    public User getUser(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping(path = "/users")
    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) {
        User userCreated = this.userService.createUser(userMapper.toEntity(userDTO));
        return this.userMapper.toDTO(userCreated);
    }

    @PutMapping(path = "/users/{userId}")
    public UserDTO updateUser(@Valid @PathVariable Long userId, @RequestBody UserDTO userDTO) {
        User userUpdated = this.userService.updateUser(userId, userMapper.toEntity(userDTO));
        return this.userMapper.toDTO(userUpdated);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(path = "/users/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        this.userService.deleteUser(userId);
    }

}
