package com.thephoenixcollective.user_service.daoImpl;

import com.thephoenixcollective.user_service.dao.UserDao;
import com.thephoenixcollective.user_service.dto.UserRequestDto;
import com.thephoenixcollective.user_service.dto.UserResponse;
import com.thephoenixcollective.user_service.entity.User;
import com.thephoenixcollective.user_service.mapper.UserMapper;
import com.thephoenixcollective.user_service.repository.UserRepository;
import com.thephoenixcollective.user_service.utility.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserResponse createuser(UserRequestDto dto) {

        try {
            if (userRepository.existsByEmail(dto.getEmail())) {
                return UserResponse.error("Email already registered");
            }
            if (userRepository.existsByPhoneNumber(dto.getPhoneNumber())) {
                return UserResponse.error("Phone number already registered");
            }
            User entity = userMapper.toEntity(dto);
            entity.setUserName(dto.getUserName());
            entity.setPassword(passwordEncoder.encode(dto.getPassword()));
            entity.setRole(dto.getRole());
            entity.setCreatedBy(AppConstants.SYSTEM);
            entity.setUpdatedBy(AppConstants.SYSTEM);
            User savedUser = userRepository.save(entity);

            return new UserResponse(true, "User has been Registered Successfully where id is -> " + savedUser.getId(), savedUser.getId());
        } catch (Exception e) {
            log.error("Failed to create user: {}", e.getMessage(), e);
            return UserResponse.error("Failed to create user: " + e.getMessage());
        }
    }

    @Override
    public UserResponse allUsers() {
       try {
            List<User> all = userRepository.findAll();
            return UserResponse.success("User fetched successfully", all);
        } catch (Exception e) {
            log.error("Failed to fetch users: {}", e.getMessage(), e);
            return UserResponse.error("Failed to fetch users");
        }
    }

}
