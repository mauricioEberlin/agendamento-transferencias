package com.mauricio.projeto.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Calendar;

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
    private Long id;

    @Column(name = "conta_origem", nullable = false)
    private String contaOrigem;

    @Column(name = "conta_destino", nullable = false)
    private String contaDestino;

    @Column(name = "valor_transferencia", nullable = false)
    private Double valorTransferencia;

    private Double taxa;

    @Column(name = "data_transferencia")
    private LocalDate dataTransferencia;

    @Column(name = "data_agendamento")
    private LocalDate dataAgendamento;

}