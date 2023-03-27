package com.epam.second.task.jmpserviceapi.service;


import com.epam.second.task.jmpdto.entity.Subscription;
import com.epam.second.task.jmpdto.model.SubscriptionRequestDto;
import com.epam.second.task.jmpdto.model.SubscriptionResponseDto;
import java.util.List;

public interface SubscriptionService {
    Subscription createSubscription(Subscription subscription);

    void deleteSubscription(Long subscriptionId);

    Subscription getSubscription(Long id);

    Subscription updateSubscription(Long subscriptionId, Subscription subscription);

    List<Subscription> getAllSubscriptions();
}