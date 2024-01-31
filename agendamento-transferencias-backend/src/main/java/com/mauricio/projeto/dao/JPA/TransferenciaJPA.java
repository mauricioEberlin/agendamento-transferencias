package com.mauricio.projeto.dao.JPA;

import com.mauricio.projeto.dao.TransferenciaDAO;
import com.mauricio.projeto.model.Transferencia;
import com.mauricio.projeto.repository.TransferenciaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class TransferenciaJPA implements TransferenciaDAO {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @Override
    public List<Transferencia> buscarTodos() {
        return transferenciaRepository.findAll();
    }

    @Override
    public void persistir(Transferencia transferencia) {
        transferenciaRepository.save(transferencia);
    }

    @Override
    public void deletar(Long id) {
        transferenciaRepository.deleteById(id);
    }
}