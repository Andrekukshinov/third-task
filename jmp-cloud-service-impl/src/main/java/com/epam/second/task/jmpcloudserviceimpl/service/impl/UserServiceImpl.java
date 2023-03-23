package com.epam.second.task.jmpcloudserviceimpl.service.impl;

import com.epam.second.task.jmpcloudserviceimpl.excpetion.UserNotFoundException;
import com.epam.second.task.jmpdto.entity.User;
import com.epam.second.task.jmpdto.repository.UserRepository;
import com.epam.second.task.jmpserviceapi.service.UserService;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final Map<Long, User> users = new ConcurrentHashMap<>();

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Transactional
    @Override
    public User updateUser(Long userId, User user) {
        Optional<User> optionalUser = repository.findById(userId);
        User foundUser = optionalUser.orElseThrow(() -> new UserNotFoundException(userId));
        foundUser.setName(user.getName());
        foundUser.setSurname(user.getSurname());
        foundUser.setBirthday(user.getBirthday());
        user.setId(userId);
        return repository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        repository.deleteById(userId);
    }

    @Override
    public User getUserById(Long userId) {
        return repository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    @Override
    public List<User> getAllUsers() {
        Iterable<User> all = repository.findAll();
        return StreamSupport.stream(all.spliterator(), false)
                .collect(Collectors.toList());
    }
}

