package com.mauricio.projeto.controller;

import com.mauricio.projeto.model.Transferencia;
import com.mauricio.projeto.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")
public class TransferenciaController {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @GetMapping("/transferencias")
    public List<Transferencia> getTransferencias(){
        return transferenciaRepository.findAll();
    }

}
