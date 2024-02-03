package com.example.internshipsentura.service;

import com.example.internshipsentura.dto.UserDto;
import com.example.internshipsentura.entity.User;
import com.example.internshipsentura.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(UserDto userDto) {

        User user = new User();
        user.setUid(userDto.getUid());
        user.setEmail(userDto.getEmail());

        userRepository.save(user);
    }
}
