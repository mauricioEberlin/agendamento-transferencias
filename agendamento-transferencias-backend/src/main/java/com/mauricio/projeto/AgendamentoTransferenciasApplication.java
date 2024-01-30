package com.mauricio.projeto;

import com.mauricio.projeto.model.Transferencia;
import com.mauricio.projeto.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class AgendamentoTransferenciasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AgendamentoTransferenciasApplication.class, args);
	}

	@Autowired
	private TransferenciaRepository transferenciaRepository;
	@Override
	public void run(String... args) throws Exception {

		Date date = new Date(System.currentTimeMillis());

		Transferencia transferencia1 = Transferencia.builder()
				.contaOrigem("04004")
				.contaDestino("05000")
				.valorTransferencia(100.00)
				.taxa(1.0)
				.dataTransferencia(date)
				.dataAgendamento(date)
				.build();

		transferenciaRepository.save(transferencia1);

	}
}
