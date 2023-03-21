package com.epam.second.task.jmpcloudserviceimpl.service.impl;

import com.epam.second.task.jmpcloudserviceimpl.excpetion.UserNotFoundException;
import com.epam.second.task.jmpdto.entity.User;
import com.epam.second.task.jmpdto.mapper.UserMapper;
import com.epam.second.task.jmpdto.model.SubscriptionResponseDto;
import com.epam.second.task.jmpdto.model.UserRequestDto;
import com.epam.second.task.jmpdto.model.UserResponseDto;
import com.epam.second.task.jmpserviceapi.service.UserService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final Map<Long, User> users = new ConcurrentHashMap<>();

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User createUser(UserRequestDto userRequestDto) {
        User user = userMapper.toUser(userRequestDto);
        Long userId = prepareUser(user);
        users.put(userId, user);
        return user;
    }

    private Long prepareUser(User user) {
        Long userId = users.size() == 0 ? 1L : Collections.max(users.keySet()) + 1L;
        user.setId(userId);
        return userId;
    }

    @Override
    public User updateUser(Long userId, UserRequestDto userRequestDto) {
        User userToUpdate = users.get(userId);
        if (userToUpdate == null) {
            throw new UserNotFoundException(userId);
        }
        User updatedUser = userMapper.toUser(userRequestDto);
        updatedUser.setId(userId);
        users.put(userId, updatedUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) {
        if (users.remove(userId) == null) {
            throw new UserNotFoundException(userId);
        }
    }

    @Override
    public User getUserById(Long userId) {
        User user = users.get(userId);
        if (user == null) {
            throw new UserNotFoundException(userId);
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }
}

