package com.application.BlogingApp.Service;

import com.application.BlogingApp.Entity.User;
import com.application.BlogingApp.Payloads.UserDto;

import java.util.List;


public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto,Integer userId);
    UserDto getOneUser(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);
}
