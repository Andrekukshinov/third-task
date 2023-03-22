package com.epam.second.task.jmpcloudserviceimpl.service.api.impl;

import com.epam.second.task.jmpdto.entity.User;
import com.epam.second.task.jmpdto.mapper.UserMapper;
import com.epam.second.task.jmpdto.model.UserRequestDto;
import com.epam.second.task.jmpdto.model.UserResponseDto;
import com.epam.second.task.jmpserviceapi.service.UserService;
import com.epam.second.task.jmpserviceapi.service.api.UserApiService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserApiServiceImpl implements UserApiService {

    private final UserService userService;
    private final UserMapper userMapper;


    public UserApiServiceImpl(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User userFromRequest = userMapper.toUser(userRequestDto);
        User user = userService.createUser(userFromRequest);
        return userMapper.toUserResponseDto(user);
    }

    @Override
    public UserResponseDto updateUser(Long userId, UserRequestDto userRequestDto) {
        User userFromRequest = userMapper.toUser(userRequestDto);
        User user = userService.updateUser(userId, userFromRequest);
        return userMapper.toUserResponseDto(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userService.deleteUser(userId);
    }

    @Override
    public UserResponseDto getUserById(Long userId) {
        User user = userService.getUserById(userId);
        return userMapper.toUserResponseDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return allUsers.stream().map(userMapper::toUserResponseDto).toList();
    }
}
