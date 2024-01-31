package com.mauricio.projeto.controller;

import com.mauricio.projeto.dao.TransferenciaDAO;
import com.mauricio.projeto.exceptions.TaxaNaoAplicavelException;
import com.mauricio.projeto.model.Transferencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
@RequestMapping("/api/transferencias")
@CrossOrigin("http://localhost:8081/")
public class TransferenciaController {

    @Autowired
    private TransferenciaDAO transferenciaDAO;

    @GetMapping
    public List<Transferencia> getTransferencias(){
        return transferenciaDAO.buscarTodos();
    }

    @PostMapping("/salvar")
    public void persistirTransferencia(@RequestBody @Validated Transferencia transferencia) throws TaxaNaoAplicavelException {

        transferencia.setDataTransferencia(LocalDate.now());

        long dias = ChronoUnit.DAYS.between(transferencia.getDataTransferencia(), transferencia.getDataAgendamento());
        Double taxa = 0.0;

        if(dias == 0){
            taxa = 2.5;
        } else if (dias >= 1 && dias <= 10) {
            taxa = 0.0;
        } else if (dias >= 11 && dias <= 20) {
            taxa = 8.2;
        } else if (dias >= 21 && dias <= 30) {
            taxa = 6.9;
        } else if (dias >= 31 && dias <= 40) {
            taxa = 4.7;
        } else if (dias >= 41 && dias <= 50) {
            taxa = 1.7;
        } else {
            throw new TaxaNaoAplicavelException("Não há taxa aplicável para essa data.");
        }

        transferencia.setTaxa(taxa);
        transferenciaDAO.persistir(transferencia);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarTransferenciaPorId(@PathVariable Long id){
        transferenciaDAO.deletar(id);
    }
}