package com.ika_climbing.service;

import com.ika_climbing.dto.ClientResponseDTO;
import com.ika_climbing.exceptions.ClientNotFoundException;
import com.ika_climbing.dto.ClientRequestDTO;
import com.ika_climbing.exceptions.ClientServiceBusinessException;
import com.ika_climbing.model.Client;
import com.ika_climbing.repository.ClientRepository;
import com.ika_climbing.utils.ValueMapper;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    @Cacheable(value = "Client")
    public List<ClientResponseDTO> getClients() throws ClientServiceBusinessException {
        List<ClientResponseDTO> clientResponseDTOS = null;
        try{
            log.info("ClientService::getClients execution started");

            List<Client> clientList = clientRepository.findAll();

            if(!clientList.isEmpty()){
                clientResponseDTOS = clientList.stream().map(ValueMapper::convertToDTO).toList();
            }else{
                clientResponseDTOS = Collections.emptyList();
            }

            log.debug("ClientService::getClients retrieving Clients from database {}", ValueMapper.jsonAsString(clientResponseDTOS));
        }catch (Exception ex){
            log.error("Exception occurred while retrieving Clients from database, Exception message {}", ex.getMessage());
            throw new ClientServiceBusinessException("Exception occurred while fetch all clients from database");
        }

        log.info("ClientService::getClients execution ended");
        return clientResponseDTOS;
    }

    @Override
    @Cacheable(value = "client")
    public ClientResponseDTO getClientById(Long id) {
        ClientResponseDTO clientResponseDTO;

        try{
            log.info("ClientService:getClientById execution started");

            Client client = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
            clientResponseDTO = ValueMapper.convertToDTO(client);
            log.debug("ClientService:getClientById retrieving Client from database for id {}", id);
        }catch (Exception ex){
            log.error("ClientService:getClientById execution ended");
            throw new ClientServiceBusinessException("Exception occurred while fetch ");
        }

        log.info("ClientService:getClientById execution ended");
        return clientResponseDTO;
    }

    @Override
    public ClientResponseDTO createClient(ClientRequestDTO clientRequestDTO) throws ClientServiceBusinessException {
        ClientResponseDTO clientResponseDTO;

        try{
            log.info("ClientService:createClient execution started");
            Client client = ValueMapper.convertToEntity(clientRequestDTO);
            log.debug("ClientService:createClient request parameters {}", ValueMapper.jsonAsString(clientRequestDTO));

            Client clientResult = clientRepository.save(client);
            clientResponseDTO = ValueMapper.convertToDTO(clientResult);
            log.debug("ClientService:createClient received response from database {}", ValueMapper.jsonAsString(clientResponseDTO));
        } catch (Exception ex){
            log.error("Exception ocurred while persisting Client to database, Exception message {}", ex.getMessage());
            throw new ClientServiceBusinessException("Exception occurred while create a new Client");
        }
        log.info("ClientService:createClient execution ended");
        return clientResponseDTO;
    }

    @Override
    public ClientResponseDTO updateClient(Long id, ClientRequestDTO clientRequestDTO) {
        ClientResponseDTO clientResponseDTO;

        try{
            log.info("ClientService:updateClient execution started");
            if(!clientRepository.existsById(id)){
                throw new ClientNotFoundException(id);
            }

            Client client = ValueMapper.convertToEntity(clientRequestDTO);
            log.debug("ClientService:updateClient request parameters {}", ValueMapper.jsonAsString(clientRequestDTO));
            Client clientResult = clientRepository.save(client);
            clientResponseDTO = ValueMapper.convertToDTO(clientResult);
            log.debug("ClientService:updateClient received response from database {}", ValueMapper.jsonAsString(clientResponseDTO));
        } catch (ClientNotFoundException ex) {
            throw ex;
        } catch (Exception ex){
            log.error("Exception occurred while updating Client to database, Exception message {}", ex.getMessage());
            throw new ClientServiceBusinessException("Exception occurred while update a Client");
        }
        log.info("ClientService:updateClient execution ended");
        return clientResponseDTO;
    }

    @Override
    public void deleteById(Long id){
        log.info("ClientService:deleteById execution started");
        try{
            if(clientRepository.existsById(id)){
                clientRepository.deleteById(id);
            }else{
                throw new ClientNotFoundException(id);
            }
        } catch (ClientNotFoundException ex) {
            throw ex;
        } catch (Exception ex){
            log.error("Exception occurred while deleting Client from database, Exception message {}", ex.getMessage());
            throw new ClientServiceBusinessException("Exception occurred while delete a Client");
        }
        log.info("ClientService:deleteById execution ended");
    }

}
