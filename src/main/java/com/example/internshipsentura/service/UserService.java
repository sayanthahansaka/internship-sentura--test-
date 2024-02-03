package com.example.internshipsentura.service;

import com.example.internshipsentura.dto.UserDto;
import com.example.internshipsentura.entity.User;
import com.example.internshipsentura.repo.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(UserDto userDto) {
        User user = new User();
        user.setUid(userDto.getUid());
        user.setEmail(userDto.getEmail());
        user.setGivenName(userDto.getGivenName());
        user.setMiddleName(userDto.getMiddleName());
        user.setName(userDto.getName());
        user.setFamilyName(userDto.getFamilyName());
        user.setNickname(userDto.getNickname());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setComment(userDto.getComment());
        user.setPicture(userDto.getPicture());
        user.setDirectory(userDto.getDirectory());
        user.setMetadata(userDto.getMetadata());
       
        user.setSuspended(userDto.isSuspended());
        user.setRoles(userDto.getRoles());

        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Transactional
    public User updateUser(Long userId, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setUid(userDto.getUid());
            existingUser.setEmail(userDto.getEmail());
            existingUser.setGivenName(userDto.getGivenName());
            existingUser.setMiddleName(userDto.getMiddleName());
            existingUser.setName(userDto.getName());
            existingUser.setFamilyName(userDto.getFamilyName());
            existingUser.setNickname(userDto.getNickname());
            existingUser.setPhoneNumber(userDto.getPhoneNumber());
            existingUser.setComment(userDto.getComment());
            existingUser.setPicture(userDto.getPicture());
            existingUser.setDirectory(userDto.getDirectory());
            existingUser.setMetadata(userDto.getMetadata());
            existingUser.setTags(userDto.getTags());
            existingUser.setSuspended(userDto.isSuspended());
            existingUser.setRoles(userDto.getRoles());

            return userRepository.save(existingUser);
        } else {
            return null; // Handle user not found error
        }
    }

    @Transactional
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
