package com.example.core.controller;

import com.example.core.model.Client;
import com.example.core.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClient();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Integer id) {
        Client client = clientService.getClientById(id).orElseThrow();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(client);
    }

    @GetMapping("cpf/{cpf}")
    public ResponseEntity<Client> getClientByCPF(@PathVariable("cpf") String cpf) {
        Optional<Client> client = clientService.getClientByCPF(cpf);

        if (client.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(client.get());
    }

    @PostMapping
    public ResponseEntity<Client> saveClient(@RequestBody Client clientBody) {
        Client client = clientService.saveClient(clientBody);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(client);
    }

    @DeleteMapping
    public <T>ResponseEntity<T> delete(@RequestParam("id") Integer idClient) {
        clientService.removeClient(idClient);

        return ResponseEntity.status(HttpStatus.RESET_CONTENT).build();
    }
}
