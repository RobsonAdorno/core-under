package com.example.core.service;

import com.example.core.core.strings.MessageException;
import com.example.core.exception.NullObjectException;
import com.example.core.model.Client;
import com.example.core.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    IClientRepository clientRepository;

    public Client saveClient(Client client) {
        if (client.getCpf() == null) throw new NullObjectException(MessageException.NULLOBJECT.getMessage());

         return clientRepository.save(client);
    }

    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    public Client getClientById(long idClient) {
        Optional<Client> client = clientRepository.findById(idClient);

        return client.orElseThrow();
    }

    public Client getClientByCPF(String cpf) {
        Optional<Client> client = clientRepository.getClientByCPF(cpf);

        return client.orElseThrow();
    }

    public void removeClient(Long id) {
        clientRepository.getOrderByIdClient(id).orElseGet(() -> {
            clientRepository.delete(getClientById(id));
            return null;
        });

        throw new NullObjectException(MessageException.CLIENTWITHORDER.getMessage());
    }

    public void removeAllClients() {
        clientRepository.deleteAll();
    }
}
