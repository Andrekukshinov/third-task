package com.epam.second.task.jmpserviceapi.repository;

import com.epam.second.task.jmpdto.entity.Subscription;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
}
