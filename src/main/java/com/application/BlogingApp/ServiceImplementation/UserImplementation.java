package com.application.BlogingApp.ServiceImplementation;

import com.application.BlogingApp.Entity.User;
import com.application.BlogingApp.Payloads.UserDto;
import com.application.BlogingApp.Repositories.UserRepository;
import com.application.BlogingApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.UserdtoToUser(userDto);
        User savedUser = this.userRepository.save(user);
        return this.UserToUserDTO(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        return null;
    }

    @Override
    public UserDto getOneUser(Integer userId) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {

    }

    private User UserdtoToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());
        return user;
    }

    private UserDto UserToUserDTO(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setAbout(user.getAbout());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
