package com.epam.second.task.jmpdto.mapper;


import com.epam.second.task.jmpdto.entity.User;
import com.epam.second.task.jmpdto.model.UserRequestDto;
import com.epam.second.task.jmpdto.model.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserRequestDto userRequestDto);

    UserResponseDto toUserResponseDto(User user);

    User fromUserResponseDto(UserResponseDto userResponseDto);
}
