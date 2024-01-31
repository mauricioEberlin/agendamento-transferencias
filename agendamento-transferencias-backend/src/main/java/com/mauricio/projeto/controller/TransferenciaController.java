package com.mauricio.projeto.controller;

import com.mauricio.projeto.model.Transferencia;
import com.mauricio.projeto.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/transferencias")
@CrossOrigin("http://localhost:8081/")
public class TransferenciaController {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @GetMapping
    public List<Transferencia> getTransferencias(){
        return transferenciaRepository.findAll();
    }

    @PostMapping("/salvar")
    public void persistirTransferencia(@RequestBody @Validated Transferencia transferencia){
        transferenciaRepository.save(transferencia);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarTransferenciaPorId(@PathVariable Long id){
        transferenciaRepository.deleteById(id);
    }

}