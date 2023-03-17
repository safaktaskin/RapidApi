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
@Table(name = "EXAMPLE")
public class Example {

    @Id
    @GeneratedValue
    private int id;
    private String status;
    private String phone_type;
    private String country_code;
    private String country_prefix;
    private String international_number;
    private String local_number;
    private String e164;
}
