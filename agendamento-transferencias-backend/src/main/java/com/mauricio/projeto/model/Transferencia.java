package com.mauricio.projeto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "transferencias")
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "conta_origem", nullable = false)
    private String contaOrigem;

    @Column(name = "conta_destino", nullable = false)
    private String contaDestino;

    @Column(name = "valor_transferencia", nullable = false)
    private Float valorTransferencia;

    private Float taxa;

    @Column(name = "data_transferencia")
    private Date dataTransferencia;

    @Column(name = "data_agendamento")
    private Date dataAgendamento;

}
