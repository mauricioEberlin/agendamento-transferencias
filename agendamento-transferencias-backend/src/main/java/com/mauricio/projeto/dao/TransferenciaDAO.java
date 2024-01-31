package com.mauricio.projeto.dao;

import com.mauricio.projeto.model.Transferencia;

import java.util.List;

public interface TransferenciaDAO {

    public List<Transferencia> buscarTodos();

    public void persistir(Transferencia transferencia);

    public void deletar(Long id);

}