package com.epam.second.task.jmpserviceapi.service;


import com.epam.second.task.jmpdto.entity.User;
import com.epam.second.task.jmpdto.model.UserRequestDto;
import com.epam.second.task.jmpdto.model.UserResponseDto;
import java.util.List;

public interface UserService {
    User createUser(UserRequestDto userRequestDto);

    User updateUser(Long userId, UserRequestDto userRequestDto);

    void deleteUser(Long userId);

    User getUserById(Long userId);

    List<User> getAllUsers();
}
