package com.ika_climbing.model;

import com.ika_climbing.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Client")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "age", nullable = false)
    private Integer age; // Integer null will assign null, int null will assign 0

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "membership_type", nullable = false)
    private String membershipType;

    private LocalDate membershipNextDate;
    private LocalDate membershipSinceDate;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "emergency_contact")
    private String emergencyContact;

    @PrePersist
    protected void onCreate(){
        status = Status.ACTIVE;
        membershipSinceDate = LocalDate.now();
        membershipNextDate = LocalDate.now().plusMonths(1);
    }

    @PreUpdate
    protected void onUpdate(){
        status = Status.ACTIVE;
        membershipNextDate = LocalDate.now().plusMonths(1);
    }

}
