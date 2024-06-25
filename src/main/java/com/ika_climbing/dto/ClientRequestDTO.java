package com.ika_climbing.dto;

import com.ika_climbing.enums.Status;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDTO {

    private Long id;

    private Status status;

    @NotBlank(message = "Client FirstName shouldn't be NULL or EMPTY")
    private String firstName;

    @NotBlank(message = "Client LastName shouldn't be NULL or EMPTY")
    private String lastName;

    @Min(value = 1,message = "Client Age can't be less than 1!")
    @Max(value = 100,message = "Client Age can't be more than 100!")
    @NotNull(message = "Client Age is mandatory")
    private Integer age; // Integer null will assign null, int null will assign 0

    @NotBlank(message = "Client Gender shouldn't be NULL or EMPTY")
    private String gender;

    @NotBlank(message = "Client Avatar shouldn't be NULL or EMPTY")
    private String avatar;

    private String membershipType;
    private LocalDate membershipNextDate;
    private LocalDate membershipSinceDate;

    private LocalDate birthday;
    private String email;
    private String phone;
    private String emergencyContact;

}
