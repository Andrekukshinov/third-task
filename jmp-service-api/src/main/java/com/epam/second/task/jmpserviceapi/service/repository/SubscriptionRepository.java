package com.epam.second.task.jmpserviceapi.service.repository;

import com.epam.second.task.jmpdto.entity.Subscription;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
}
