package com.example.core.service;

import com.example.core.model.Client;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClientServiceTest {
    @Autowired
    ClientService clientRepository;

    public Client client;

    @BeforeEach
    public void setUp() {
        client = new Client("30912", "Robson", "Adorno");
    }

    @Test
    @DisplayName("Deve ser possível adicionar um cliente")
    public void addClient() {
        Client client = clientRepository.saveClient(this.client);

        Assertions.assertEquals(client.getName(), "Robson");
    }

    @Test
    @DisplayName("Deve ser possível listar todos os clientes")
    public void listAllClients() {
        List<Client> clientList = clientRepository.getAllClient();

        Assertions.assertNotNull(clientList);
    }

    @Test
    @DisplayName("Deve ser possível atualizar os dados de um cliente.")
    public void updateClient() {
        List<Client> clientList = clientRepository.getAllClient();

        Assertions.assertNotNull(clientList);
    }

    @Test
    @DisplayName("Deve ser possível excluir um cliente que não possua pedidos. Se houver uma\n" +
            "tentativa de exclusão de clientes com pedidos uma mensagem do sistema deve\n" +
            "informar ao usuário que o cliente não pode ser excluído.")
    public void shouldRemoveAClient() {

    }
}
