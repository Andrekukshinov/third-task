package com.epam.second.task.jmpservicerest.controller;

import com.epam.second.task.jmpdto.entity.User;
import com.epam.second.task.jmpdto.mapper.UserMapper;
import com.epam.second.task.jmpdto.model.UserRequestDto;
import com.epam.second.task.jmpdto.model.UserResponseDto;
import com.epam.second.task.jmpserviceapi.service.UserService;
import com.epam.second.task.jmpserviceapi.service.api.UserApiService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserApiService userService;

    public UserController(UserApiService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto userDto) {
        return userService.createUser(userDto);
    }

    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable Long id, @RequestBody UserRequestDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public UserResponseDto getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserResponseDto> getAllUser() {
        return userService.getAllUsers();
    }
}