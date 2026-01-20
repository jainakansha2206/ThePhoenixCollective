package com.thephoenixcollective.user_service.mapper;

import com.thephoenixcollective.user_service.dto.UserRequestDto;
import com.thephoenixcollective.user_service.dto.UserResponseDto;
import com.thephoenixcollective.user_service.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "email", source = "email")
    User toEntity(UserRequestDto dto);

    UserResponseDto toResponseDto(User entity);

    List<UserResponseDto> toResponseDtos(List<User> entities);
}
