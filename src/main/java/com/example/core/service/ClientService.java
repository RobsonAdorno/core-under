package com.example.core.service;

import com.example.core.core.strings.MessageException;
import com.example.core.exception.NullObjectException;
import com.example.core.model.modelRedundant.Client;
import com.example.core.repository.IClientRepository;
import com.example.core.repository.TokenRepository;
import com.example.core.security.JWTUtils;
import com.example.core.security.auth.AuthenticationRequest;
import com.example.core.security.auth.AuthenticationResponse;
import com.example.core.security.token.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    AuthenticationManager authenticationManager;
    private final IClientRepository clientRepository;
    private final JWTUtils jwtUtils;
    private final TokenRepository tokenRepository;

    public ClientService(
                         TokenRepository tokenRepository,
                         IClientRepository clientRepository,
                         JWTUtils jwtUtils
                         ) {
        this.tokenRepository = tokenRepository;
        this.clientRepository = clientRepository;
        this.jwtUtils = jwtUtils;
    }

    public AuthenticationResponse saveClient(Client client) {
        if (client.getUser().getCpf() == null)
            throw new NullObjectException(MessageException.NULLOBJECT.getMessage());

        var clientVar = clientRepository.save(client);

        var jwtToken = jwtUtils.generateToken(clientVar.getUsername());
        var refreshToken = jwtUtils.generateRefreshToken(clientVar.getUsername());

        return AuthenticationResponse
                .builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        Client user = clientRepository.getClientByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtUtils.generateToken(user.getUsername());
        var refreshToken = jwtUtils.generateRefreshToken(user.getUsername());

        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    private void saveUserToken(Client client, String jwtToken) {
        var token = Token.builder()
                .client(client)
                .token(jwtToken)
                .tokenType(Token.TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();

        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(Client client) {
        var validUserTokens = tokenRepository.findAll();
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }
//
//    public Optional<Client> getClientById(Integer idClient) {
//        Long id = Long.valueOf(idClient);
//        return clientRepository.findById(id);
//    }
//
//    public Optional<Client> getClientByCPF(String cpf) {
//        return clientRepository.getClientByCPF(cpf);
//    }
//
//    public void removeClient(Integer id) {
//        Optional<Client> client = getClientById(id);
//
//        client.ifPresent(clientFunc -> clientRepository.delete(clientFunc));
//    }

//    public void removeClient(Integer id) {
//        clientRepository.getOrderByIdClient(id).orElseGet(() -> {
//            clientRepository.delete(getClientById(id));
//            return null;
//        });
//
//        throw new NullObjectException(MessageException.CLIENTWITHORDER.getMessage());
//    }

    public void removeAllClients() {
        clientRepository.deleteAll();
    }
}
