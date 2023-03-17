package com.rapidapi.crud.example.dto;

import lombok.Data;

@Data
public class ExampleDto {

    private String status;
    private String phone_type;
    private String country_code;
    private String country_prefix;
    private String international_number;
    private String local_number;
    private String e164;
}
