package com.rapidapi.crud.example.service;

import com.rapidapi.crud.example.entity.Verify;
import com.rapidapi.crud.example.repository.VerifyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerifyService {
    @Autowired
    private VerifyRepository repository;

    public Verify saveVerify(Verify verify) {
        return repository.save(verify);
    }

    public List<Verify> saveVerifys(List<Verify> verifys) {
        return repository.saveAll(verifys);
    }

    public List<Verify> getVerifys() {
        return repository.findAll();
    }

    public Verify getVerifyById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Verify getVerifyByName(String name) {
        return repository.findByName(name);
    }

    public String deleteVerify(int id) {
        repository.deleteById(id);
        return "verify removed !! " + id;
    }

    public Verify updateVerify(Verify verify) {
        Verify existingVerify = repository.findById(verify.getId()).orElse(null);
        existingVerify.setStatus(verify.getStatus());
        existingVerify.setPhone(verify.getPhone());
        existingVerify.setPhone_valid(verify.getPhone_valid());
        existingVerify.setPhone_type(verify.getPhone_type());
        existingVerify.setPhone_region(verify.getPhone_region());
        existingVerify.setCountry(verify.getCountry());
        existingVerify.setCountry_code(verify.getCountry_code());
        existingVerify.setCountry_prefix(verify.getCountry_prefix());
        existingVerify.setInternational_number(verify.getInternational_number());
        existingVerify.setLocal_number(verify.getLocal_number());
        existingVerify.setE164(verify.getE164());
        existingVerify.setCarrier(verify.getCarrier());
        return repository.save(existingVerify);
    }


}
