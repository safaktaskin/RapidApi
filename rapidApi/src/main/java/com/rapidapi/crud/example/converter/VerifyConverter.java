package com.rapidapi.crud.example.converter;

import com.rapidapi.crud.example.dto.VerifyDto;
import com.rapidapi.crud.example.entity.Verify;
import com.rapidapi.crud.example.repository.VerifyRepository;
import org.modelmapper.ModelMapper;

public class VerifyConverter {
    private VerifyRepository verifyRepository;
    private ModelMapper modelMapper;


    public VerifyConverter(VerifyRepository verifyRepository, ModelMapper modelMapper) {
        this.verifyRepository = verifyRepository;
        this.modelMapper = modelMapper;
    }

    private VerifyDto convertVerifyDto(Verify verify){
        VerifyDto verifyDto = modelMapper.map(verify, VerifyDto.class);
        return verifyDto;
    }

    private Verify convertVerify(VerifyDto verifyDto){
        Verify verify = modelMapper.map(verifyDto, Verify.class);
        return verify;
    }

}
