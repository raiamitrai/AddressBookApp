package com.amit.addressBookApp.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Data
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;

    private String addressBookName;
}
