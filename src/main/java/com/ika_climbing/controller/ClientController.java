package com.ika_climbing.controller;

import com.ika_climbing.dto.ClientRequestDTO;
import com.ika_climbing.dto.ClientResponseDTO;
import com.ika_climbing.service.ClientServiceImpl;
import com.ika_climbing.utils.ValueMapper;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin("http://localhost:3000")
@Slf4j
public class ClientController {

    private final ClientServiceImpl clientService;

    @Autowired
    public ClientController(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> getClients() {
        log.info("ClientController::getClients request");
        List<ClientResponseDTO> clientsResponseDTO = clientService.getClients();
        log.info("ClientController::getClients response {}", ValueMapper.jsonAsString(clientsResponseDTO));
        return ResponseEntity.ok(clientsResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> getClientById(@PathVariable Long id) {
        log.info("ClientController::getClientById by ID {}", id);
        ClientResponseDTO clientResponseDTO = clientService.getClientById(id);
        log.info("ClientController::getClientById by ID {} response {}", id, ValueMapper.jsonAsString(clientResponseDTO));
        return ResponseEntity.ok(clientResponseDTO);
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> createClient(@RequestBody @Valid ClientRequestDTO clientRequestDTO) {
        log.info("ClientController::createClient request {}", ValueMapper.jsonAsString(clientRequestDTO));
        ClientResponseDTO clientResponseDTO  = clientService.createClient(clientRequestDTO);
        log.info("ClientController::createClient response {}", ValueMapper.jsonAsString(clientResponseDTO));
        return new ResponseEntity<>(clientResponseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClient(@PathVariable("id") Long id, @RequestBody @Valid ClientRequestDTO clientRequestDTO) {
        log.info("ClientController::updateClient request {}", ValueMapper.jsonAsString(clientRequestDTO));
        ClientResponseDTO clientResponseDTO = clientService.updateClient(id, clientRequestDTO);
        log.info("ClientController::updateClient response {}", ValueMapper.jsonAsString(clientResponseDTO));
        return ResponseEntity.ok(clientResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        log.info("ClientController::deleteClient with ID {}", id);
        clientService.deleteById(id);
        log.info("ClientController::deleteClient response ended");
        return ResponseEntity.noContent().build();
    }

}