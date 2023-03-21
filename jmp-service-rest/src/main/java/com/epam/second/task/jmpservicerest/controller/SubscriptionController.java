package com.epam.second.task.jmpservicerest.controller;

import com.epam.second.task.jmpdto.entity.Subscription;
import com.epam.second.task.jmpdto.mapper.SubscriptionMapper;
import com.epam.second.task.jmpdto.model.SubscriptionRequestDto;
import com.epam.second.task.jmpdto.model.SubscriptionResponseDto;
import com.epam.second.task.jmpserviceapi.service.SubscriptionService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;
    private final SubscriptionMapper subscriptionMapper;


    public SubscriptionController(SubscriptionService subscriptionService, SubscriptionMapper subscriptionMapper) {
        this.subscriptionService = subscriptionService;
        this.subscriptionMapper = subscriptionMapper;
    }

    @PostMapping
    public SubscriptionResponseDto createSubscription(@RequestBody SubscriptionRequestDto subscriptionDto) {
        Subscription subscription = subscriptionService.createSubscription(subscriptionDto);

        return subscriptionMapper.toResponseDto(subscription);
    }

    @PutMapping("/{id}")
    public SubscriptionResponseDto updateSubscription(@PathVariable Long id, @RequestBody SubscriptionRequestDto subscriptionDto) {

        Subscription subscription = subscriptionService.updateSubscription(id, subscriptionDto);

        return subscriptionMapper.toResponseDto(subscription);
    }

    @DeleteMapping("/{id}")
    public void deleteSubscription(@PathVariable Long id) {
        subscriptionService.deleteSubscription(id);
    }

    @GetMapping("/{id}")
    public SubscriptionResponseDto getSubscription(@PathVariable Long id) {

        Subscription subscription = subscriptionService.getSubscription(id);

        return subscriptionMapper.toResponseDto(subscription);

    }

    @GetMapping
    public List<SubscriptionResponseDto> getAllSubscription() {
        return subscriptionService.getAllSubscriptions()
                .stream()
                .map(subscriptionMapper::toResponseDto)
                .collect(Collectors.toList());
    }

}
