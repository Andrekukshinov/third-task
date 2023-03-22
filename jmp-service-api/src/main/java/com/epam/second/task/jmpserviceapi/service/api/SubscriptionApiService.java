package com.epam.second.task.jmpserviceapi.service.api;


import com.epam.second.task.jmpdto.entity.Subscription;
import com.epam.second.task.jmpdto.model.SubscriptionRequestDto;
import com.epam.second.task.jmpdto.model.SubscriptionResponseDto;
import java.util.List;

public interface SubscriptionApiService {
    SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequestDto);

    void deleteSubscription(Long subscriptionId);

    SubscriptionResponseDto getSubscription(Long id);

    SubscriptionResponseDto updateSubscription(Long subscriptionId, SubscriptionRequestDto subscriptionRequestDto);

    List<SubscriptionResponseDto> getAllSubscriptions();
}