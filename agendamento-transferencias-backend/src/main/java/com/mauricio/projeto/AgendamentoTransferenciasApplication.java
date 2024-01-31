package com.mauricio.projeto;

import com.mauricio.projeto.model.Transferencia;
import com.mauricio.projeto.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication
public class AgendamentoTransferenciasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AgendamentoTransferenciasApplication.class, args);
	}

	@Autowired
	private TransferenciaRepository transferenciaRepository;
	@Override
	public void run(String... args) throws Exception {

		LocalDate localDate = LocalDate.now();

		localDate.getDayOfMonth();

		Transferencia transferencia1 = Transferencia.builder()
				.contaOrigem("04004")
				.contaDestino("05000")
				.valorTransferencia(100.00)
				.taxa(1.0)
				.dataTransferencia(localDate)
				.dataAgendamento(localDate)
				.build();

		transferenciaRepository.save(transferencia1);

	}
}
