//package com.example.core.security.service;
//
//import com.example.core.config.SecurityConfig;
//import com.example.core.model.modelRedundant.Client;
//import com.example.core.repository.IClientRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UserService {
//
//    private final IClientRepository clientRepository;
//
//    private final SecurityConfig securityConfig;
//
//    @Autowired
//    public UserService(IClientRepository clientRepository, SecurityConfig securityConfig) {
//        this.securityConfig = securityConfig;
//        this.clientRepository = clientRepository;
//    }
//
//    public List<Client> users() {
//        return clientRepository.findAll();
//    }
//
//    public Client saveUser(Client client) {
//        String hash = securityConfig.bCryptPasswordEncoder().encode(client.getPassword());
//        client.getUser().setPassword(hash);
//
//        return clientRepository.save(client);
//    }
//
//    public void removeAllUsers() {
//        clientRepository.deleteAll();
//    }
//}
