package com.ika_climbing.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ika_climbing.dto.ClientResponseDTO;
import com.ika_climbing.model.Client;
import com.ika_climbing.dto.ClientRequestDTO;

public class ValueMapper {

    public static Client convertToEntity(ClientRequestDTO clientRequestDTO){
        Client client = new Client();
        client.setId(clientRequestDTO.getId());
        client.setStatus(clientRequestDTO.getStatus());
        client.setFirstName(clientRequestDTO.getFirstName());
        client.setLastName(clientRequestDTO.getLastName());
        client.setAge(clientRequestDTO.getAge());
        client.setGender(clientRequestDTO.getGender());
        client.setBirthday(clientRequestDTO.getBirthday());
        client.setAvatar(clientRequestDTO.getAvatar());
        client.setMembershipType(clientRequestDTO.getMembershipType());
        client.setMembershipNextDate(clientRequestDTO.getMembershipNextDate());
        client.setMembershipSinceDate(clientRequestDTO.getMembershipSinceDate());
        client.setEmail(clientRequestDTO.getEmail());
        client.setPhone(clientRequestDTO.getPhone());
        client.setEmergencyContact(clientRequestDTO.getEmergencyContact());
        return client;
    }

    public static ClientResponseDTO convertToDTO(Client client){
        ClientResponseDTO clientResponseDTO = new ClientResponseDTO();
        clientResponseDTO.setId(client.getId());
        clientResponseDTO.setStatus(client.getStatus());
        clientResponseDTO.setFirstName(client.getFirstName());
        clientResponseDTO.setLastName(client.getLastName());
        clientResponseDTO.setAge(client.getAge());
        clientResponseDTO.setGender(client.getGender());
        clientResponseDTO.setBirthday(client.getBirthday());
        clientResponseDTO.setAvatar(client.getAvatar());
        clientResponseDTO.setMembershipType(client.getMembershipType());
        clientResponseDTO.setMembershipNextDate(client.getMembershipNextDate());
        clientResponseDTO.setMembershipSinceDate(client.getMembershipSinceDate());
        clientResponseDTO.setEmail(client.getEmail());
        clientResponseDTO.setPhone(client.getPhone());
        clientResponseDTO.setEmergencyContact(client.getEmergencyContact());
        return clientResponseDTO;
    }

    public static String jsonAsString(Object obj){
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
