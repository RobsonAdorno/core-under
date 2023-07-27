package com.example.core.controller.controllerRedundant;

import com.example.core.model.modelRedundant.Client;
import com.example.core.security.auth.AuthenticationRequest;
import com.example.core.security.auth.AuthenticationResponse;
import com.example.core.service.ClientService;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
@AllArgsConstructor
public class ClientController {
    final ClientService clientService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> saveClient(@RequestBody Client clientBody) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(clientService.saveClient(clientBody));
    }

    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponse> authentication(
                                @RequestBody AuthenticationRequest authentication) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(clientService.authenticate(authentication));
    }

    @GetMapping("/allClients")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClient();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(clients);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Client> getClientById(@PathVariable("id") Integer id) {
//        Client client = clientService.getClientById(id).orElseThrow();
//
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(client);
//    }

//    @GetMapping("cpf/{cpf}")
//    public ResponseEntity<Client> getClientByCPF(@PathVariable("cpf") String cpf) {
//        Optional<Client> client = clientService.getClientByCPF(cpf);
//
//        if (client.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
//
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(client.get());
//    }

//    @PostMapping
//    public ResponseEntity<Client> saveClient(@RequestBody Client clientBody) {
//        Client client = clientService.saveClient(clientBody);
//
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(client);
//    }

//    @DeleteMapping
//    public <T>ResponseEntity<T> delete(@RequestParam("id") Integer idClient) {
//        clientService.removeClient(idClient);
//
//        return ResponseEntity.status(HttpStatus.RESET_CONTENT).build();
//    }
}
