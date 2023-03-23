package com.epam.second.task.jmpservicerest.controller;

import com.epam.second.task.jmpdto.entity.Subscription;
import com.epam.second.task.jmpdto.mapper.SubscriptionMapper;
import com.epam.second.task.jmpdto.model.SubscriptionRequestDto;
import com.epam.second.task.jmpdto.model.SubscriptionResponseDto;
import com.epam.second.task.jmpserviceapi.service.SubscriptionService;
import com.epam.second.task.jmpserviceapi.service.api.SubscriptionApiService;
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
    @RequestMapping("api/v1/subscriptions")
public class SubscriptionController {
    private final SubscriptionApiService subscriptionService;


    public SubscriptionController(SubscriptionApiService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping
    public SubscriptionResponseDto createSubscription(@RequestBody SubscriptionRequestDto subscriptionDto) {
        return subscriptionService.createSubscription(subscriptionDto);
    }

    @PutMapping("/{id}")
    public SubscriptionResponseDto updateSubscription(@PathVariable Long id, @RequestBody SubscriptionRequestDto subscriptionDto) {
        return subscriptionService.updateSubscription(id, subscriptionDto);
    }

    @DeleteMapping("/{id}")
    public void deleteSubscription(@PathVariable Long id) {
        subscriptionService.deleteSubscription(id);
    }

    @GetMapping("/{id}")
    public SubscriptionResponseDto getSubscription(@PathVariable Long id) {
        return subscriptionService.getSubscription(id);
    }

    @GetMapping
    public List<SubscriptionResponseDto> getAllSubscription() {
        return new ArrayList<>(subscriptionService.getAllSubscriptions());
    }

}
