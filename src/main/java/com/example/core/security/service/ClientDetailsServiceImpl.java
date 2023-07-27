package com.example.core.security.service;

import com.example.core.model.modelRedundant.Client;
import com.example.core.repository.IClientRepository;
import com.example.core.security.UserSpringSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ClientDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.getClientByEmail(username).orElseThrow(() ->
                new UsernameNotFoundException("Usuário ou senha inválido!"));

        return new UserSpringSecurity(client.getUser().getEmail(), client.getPassword());
    }
}
