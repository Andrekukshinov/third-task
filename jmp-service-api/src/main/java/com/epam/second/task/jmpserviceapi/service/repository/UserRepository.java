package com.epam.second.task.jmpserviceapi.service.repository;

import com.epam.second.task.jmpdto.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
