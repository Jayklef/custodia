package com.jayklef.custodia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NextOfKin {
    private String name;
    private String email;
    private String mobileNumber;
    private String relationship;
}
