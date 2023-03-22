package com.epam.second.task.jmpserviceapi.service.api;

import com.epam.second.task.jmpdto.entity.User;
import com.epam.second.task.jmpdto.model.UserRequestDto;
import com.epam.second.task.jmpdto.model.UserResponseDto;
import java.util.List;

public interface UserApiService {
    UserResponseDto createUser(UserRequestDto userRequestDto);

    UserResponseDto updateUser(Long userId, UserRequestDto userRequestDto);

    void deleteUser(Long userId);

    UserResponseDto getUserById(Long userId);

    List<UserResponseDto> getAllUsers();
}
