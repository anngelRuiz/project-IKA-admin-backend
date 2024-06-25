package com.ika_climbing.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ika_climbing.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientResponseDTO {

    private Long id;
    private Status status;
    private String firstName;
    private String lastName;
    private Integer age;
    private String gender;
    private LocalDate birthday;
    private String avatar;

    private String membershipType;
    private LocalDate membershipNextDate;
    private LocalDate membershipSinceDate;

    private String email;
    private String phone;
    private String emergencyContact;

}
