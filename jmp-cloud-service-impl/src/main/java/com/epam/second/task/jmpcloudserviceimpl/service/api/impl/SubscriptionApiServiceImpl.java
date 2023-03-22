package com.epam.second.task.jmpcloudserviceimpl.service.api.impl;

import com.epam.second.task.jmpdto.entity.Subscription;
import com.epam.second.task.jmpdto.mapper.SubscriptionMapper;
import com.epam.second.task.jmpdto.mapper.SubscriptionMapperImpl;
import com.epam.second.task.jmpdto.model.SubscriptionRequestDto;
import com.epam.second.task.jmpdto.model.SubscriptionResponseDto;
import com.epam.second.task.jmpserviceapi.service.SubscriptionService;
import com.epam.second.task.jmpserviceapi.service.api.SubscriptionApiService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionApiServiceImpl implements SubscriptionApiService {

    private final SubscriptionMapper subscriptionMapper;
    private final SubscriptionService subscriptionService;

    public SubscriptionApiServiceImpl(SubscriptionMapperImpl subscriptionMapper, SubscriptionService subscriptionService) {
        this.subscriptionMapper = subscriptionMapper;
        this.subscriptionService = subscriptionService;
    }

    @Override
    public SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequestDto) {
        Subscription subscription = subscriptionMapper.toSubscription(subscriptionRequestDto);
        Subscription serviceSubscription = subscriptionService.createSubscription(subscription);
        return subscriptionMapper.toResponseDto(serviceSubscription);
    }

    @Override
    public void deleteSubscription(Long subscriptionId) {
         subscriptionService.deleteSubscription(subscriptionId);
    }

    @Override
    public SubscriptionResponseDto getSubscription(Long id) {
        Subscription serviceSubscription = subscriptionService.getSubscription(id);
        return subscriptionMapper.toResponseDto(serviceSubscription);
    }

    @Override
    public SubscriptionResponseDto updateSubscription(Long subscriptionId, SubscriptionRequestDto subscriptionRequestDto) {
        Subscription subscription = subscriptionMapper.toSubscription(subscriptionRequestDto);
        Subscription serviceSubscription = subscriptionService.updateSubscription(subscriptionId, subscription);
        return subscriptionMapper.toResponseDto(serviceSubscription);
    }

    @Override
    public List<SubscriptionResponseDto> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions()
                .stream()
                .map(subscriptionMapper::toResponseDto)
                .toList();
    }
}
