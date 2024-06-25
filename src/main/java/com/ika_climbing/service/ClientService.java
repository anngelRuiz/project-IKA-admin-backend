package com.ika_climbing.service;

import com.ika_climbing.dto.ClientResponseDTO;
import com.ika_climbing.dto.ClientRequestDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientService {

    List<ClientResponseDTO> getClients();
    ClientResponseDTO getClientById(Long id);
    ClientResponseDTO createClient(ClientRequestDTO clientRequestDTO);
    ClientResponseDTO updateClient(Long id, ClientRequestDTO clientRequestDTO);
    void deleteById(Long id);

}
