package com.rapidapi.crud.example.controller;

import com.rapidapi.crud.example.entity.Verify;
import com.rapidapi.crud.example.service.VerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VerifyController {

    @Autowired
    private VerifyService service;

    @PostMapping("/addVerify")
    public Verify addVerify(@RequestBody Verify verify) {
        return service.saveVerify(verify);
    }

    @PostMapping("/addVerifys")
    public List<Verify> addVerifys(@RequestBody List<Verify> verifys) {
        return service.saveVerifys(verifys);
    }

    @GetMapping("/verifys")
    public List<Verify> findAllVerifys() {
        return service.getVerifys();
    }

    @GetMapping("/verifyById/{id}")
    public Verify findVerifyById(@PathVariable int id) {
        return service.getVerifyById(id);
    }

    @GetMapping("/verify/{name}")
    public Verify findVerifyByName(@PathVariable String name) {
        return service.getVerifyByName(name);
    }

    @PutMapping("/update")
    public Verify updateVerify(@RequestBody Verify verify) {
        return service.updateVerify(verify);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteVerify(@PathVariable int id) {
        return service.deleteVerify(id);
    }
}
