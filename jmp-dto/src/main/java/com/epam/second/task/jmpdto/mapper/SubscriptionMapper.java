package com.epam.second.task.jmpdto.mapper;

import com.epam.second.task.jmpdto.entity.Subscription;
import com.epam.second.task.jmpdto.model.SubscriptionRequestDto;
import com.epam.second.task.jmpdto.model.SubscriptionResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    SubscriptionMapper INSTANCE = Mappers.getMapper(SubscriptionMapper.class);

    @Mapping(source = "user.id", target = "userId")
    SubscriptionResponseDto toResponseDto(Subscription subscription);

    Subscription toSubscription(SubscriptionRequestDto requestDto);

}