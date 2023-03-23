package com.epam.second.task.jmpcloudserviceimpl.service.impl;

import com.epam.second.task.jmpcloudserviceimpl.excpetion.SubscriptionNotFoundException;
import com.epam.second.task.jmpdto.entity.Subscription;
import com.epam.second.task.jmpdto.repository.SubscriptionRepository;
import com.epam.second.task.jmpserviceapi.service.SubscriptionService;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Subscription createSubscription(Subscription subscription) {
        subscription.setStartDate(LocalDate.now());
        return subscriptionRepository.save(subscription);
    }

    @Transactional
    @Override
    public Subscription updateSubscription(Long subscriptionId, Subscription updatedSubscription) {
        Subscription subscriptionToUpdate = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(SubscriptionNotFoundException::new);
        updatedSubscription.setUser(subscriptionToUpdate.getUser());
        updatedSubscription.setId(subscriptionId);
        return subscriptionRepository.save(updatedSubscription);
    }

    @Override
    public void deleteSubscription(Long subscriptionId) {
        subscriptionRepository.deleteById(subscriptionId);
    }

    @Override
    public Subscription getSubscription(Long subscriptionId) {
        return subscriptionRepository
                .findById(subscriptionId)
                .orElseThrow(SubscriptionNotFoundException::new);
    }

    @Override
    public List<Subscription> getAllSubscriptions() {
        List<Subscription> subs = new ArrayList<>();
        subscriptionRepository.findAll().forEach(subs::add);
        return subs;
    }
}

