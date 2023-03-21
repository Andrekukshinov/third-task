package com.epam.second.task.jmpserviceapi.service;


import com.epam.second.task.jmpdto.entity.Subscription;
import com.epam.second.task.jmpdto.model.SubscriptionRequestDto;
import com.epam.second.task.jmpdto.model.SubscriptionResponseDto;
import java.util.List;

public interface SubscriptionService {
    Subscription createSubscription(SubscriptionRequestDto subscriptionRequestDto);

    void deleteSubscription(Long subscriptionId);

    Subscription getSubscription(Long id);

    Subscription updateSubscription(Long subscriptionId, SubscriptionRequestDto subscriptionRequestDto);

    List<Subscription> getAllSubscriptions();
}