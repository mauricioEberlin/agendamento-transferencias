package com.mauricio.projeto.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    private Double valorTransferencia;

    private Double taxa;

    @Column(name = "data_transferencia")
    private Date dataTransferencia;

    @Column(name = "data_agendamento")
    private Date dataAgendamento;

}