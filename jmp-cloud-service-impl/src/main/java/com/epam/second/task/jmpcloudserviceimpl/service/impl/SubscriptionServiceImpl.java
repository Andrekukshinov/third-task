package com.epam.second.task.jmpcloudserviceimpl.service.impl;

import com.epam.second.task.jmpcloudserviceimpl.excpetion.SubscriptionNotFoundException;
import com.epam.second.task.jmpdto.entity.Subscription;
import com.epam.second.task.jmpdto.entity.User;
import com.epam.second.task.jmpdto.mapper.SubscriptionMapper;
import com.epam.second.task.jmpdto.model.SubscriptionRequestDto;
import com.epam.second.task.jmpserviceapi.service.SubscriptionService;
import com.epam.second.task.jmpserviceapi.service.UserService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionMapper subscriptionMapper;
    private final Map<Long, Subscription> subscriptions = new ConcurrentHashMap<>();
    private final UserService userService;

    public SubscriptionServiceImpl(SubscriptionMapper subscriptionMapper, UserService userService) {
        this.subscriptionMapper = subscriptionMapper;
        this.userService = userService;
    }

    @Override
    public Subscription createSubscription(SubscriptionRequestDto subscriptionRequestDto) {
        Subscription subscription = subscriptionMapper.toSubscription(subscriptionRequestDto);

        Long subscriptionId = prepareSubscription(subscriptionRequestDto, subscription);

        subscriptions.put(subscriptionId, subscription);
        return subscription;
    }

    private Long prepareSubscription(SubscriptionRequestDto subscriptionRequestDto, Subscription subscription) {
        Long userId = subscriptionRequestDto.getUserId();
        User user = userService.getUserById(userId);
        subscription.setUser(user);
        Long subscriptionId = subscriptions.size() == 0 ? 1L : Collections.max(subscriptions.keySet()) + 1L;
        subscription.setId(subscriptionId);
        return subscriptionId;
    }

    @Override
    public Subscription updateSubscription(Long subscriptionId, SubscriptionRequestDto subscriptionRequestDto) {
        Subscription subscriptionToUpdate = subscriptions.get(subscriptionId);
        if (subscriptionToUpdate == null) {
            throw new SubscriptionNotFoundException();
        }
        Subscription updatedSubscription = subscriptionMapper.toSubscription(subscriptionRequestDto);
        updatedSubscription.setUser(subscriptionToUpdate.getUser());
        updatedSubscription.setId(subscriptionId);
        subscriptions.put(subscriptionId, updatedSubscription);
        return updatedSubscription;
    }

    @Override
    public void deleteSubscription(Long subscriptionId) {
        if (subscriptions.remove(subscriptionId) == null) {
            throw new SubscriptionNotFoundException();
        }
    }

    @Override
    public Subscription getSubscription(Long subscriptionId) {
        Subscription subscription = subscriptions.get(subscriptionId);
        if (subscription == null) {
            throw new SubscriptionNotFoundException();
        }
        return subscription;
    }

    @Override
    public List<Subscription> getAllSubscriptions() {
        return new ArrayList<>(subscriptions.values());
    }
}

