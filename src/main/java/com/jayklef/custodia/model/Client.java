package com.jayklef.custodia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {

    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private Long clientId;

    @NotBlank(message = "Please enter a profile name")
    private String clientName;
    private String gender;

    @Email
    private String clientEmail;
    private LocalDate birthDate;
    private String clientAddress;
    private String clientMobile;

    @Embedded
    private NextOfKin nextOfKin;

    @OneToMany(
            mappedBy = "client"
    )
    private List<Item> items;
}
