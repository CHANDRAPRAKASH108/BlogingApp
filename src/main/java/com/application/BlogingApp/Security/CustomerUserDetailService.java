package com.application.BlogingApp.Security;

import com.application.BlogingApp.Entity.User;
import com.application.BlogingApp.Exceptions.ResourceNotFoundException;
import com.application.BlogingApp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User","Id:" +username,0));
        return user;
    }
}
