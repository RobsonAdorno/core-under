package com.example.core.security.service;

import com.example.core.model.modelRedundant.User;
import com.example.core.repository.IUserRepository;
import com.example.core.security.UserSpringSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ClientDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username).orElseThrow(() ->
                new UsernameNotFoundException("Usuário ou senha inválido!"));

        return new UserSpringSecurity(user.getEmail(), user.getPassword());
    }
}
