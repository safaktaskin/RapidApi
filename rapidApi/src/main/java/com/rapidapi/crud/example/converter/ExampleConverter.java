package com.rapidapi.crud.example.converter;

import com.rapidapi.crud.example.dto.ExampleDto;
import com.rapidapi.crud.example.entity.Example;
import com.rapidapi.crud.example.repository.ExampleRepository;
import org.modelmapper.ModelMapper;

public class ExampleConverter {
    private ExampleRepository exampleRepository;
    private ModelMapper modelMapper;

    public ExampleConverter(ExampleRepository exampleRepository, ModelMapper modelMapper) {
        this.exampleRepository = exampleRepository;
        this.modelMapper = modelMapper;
    }

    private ExampleDto exampleDto(Example example){
        ExampleDto exampleDto = modelMapper.map(example, ExampleDto.class);
        return exampleDto;
    }

    private Example example(ExampleDto exampleDto) {
        Example map = modelMapper.map(exampleDto, Example.class);
        return map;
    }

}
