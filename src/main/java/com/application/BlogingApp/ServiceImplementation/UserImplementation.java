package com.application.BlogingApp.ServiceImplementation;

import com.application.BlogingApp.Entity.User;
import com.application.BlogingApp.Exceptions.ResourceNotFoundException;
import com.application.BlogingApp.Payloads.UserDto;
import com.application.BlogingApp.Repositories.UserRepository;
import com.application.BlogingApp.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.UserdtoToUser(userDto);
        User savedUser = this.userRepository.save(user);
        return this.UserToUserDTO(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow((()->new ResourceNotFoundException("User","Id",userId)));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User updateUser = userRepository.save(user);
        return this.UserToUserDTO(updateUser);
    }

    @Override
    public UserDto getOneUser(Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        return this.UserToUserDTO(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        return users.stream().map(this::UserToUserDTO).toList();
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Users","Id ",userId));
        this.userRepository.deleteById(userId);
    }

    private User UserdtoToUser(UserDto userDto){
        return this.modelMapper.map(userDto,User.class);
    }

    private UserDto UserToUserDTO(User user){
        return this.modelMapper.map(user,UserDto.class);
    }
}
