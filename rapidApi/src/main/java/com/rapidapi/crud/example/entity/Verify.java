package com.rapidapi.crud.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "VERIFY")
public class Verify {

    @Id
    @GeneratedValue
    private int id;
    private String status;
    private String phone;
    private Boolean phone_valid;
    private String phone_type;
    private String phone_region;
    private String country;
    private String country_code;
    private String country_prefix;
    private String international_number;
    private String local_number;
    private String e164;
    private String carrier;
}
