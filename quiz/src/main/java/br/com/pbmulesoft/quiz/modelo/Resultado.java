package br.com.pbmulesoft.quiz.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RESULTADOS")
public class Resultado {

	@Id
	@GeneratedValue
	private Long id;
	private String jogador;
	private int acertos;
	private int erros;
	private LocalDate dataDaPartida = LocalDate.now();;
	
	public Resultado() {
	}
	
	public Resultado(String jogador, int acertos, int erros, LocalDate data) { 
		this.jogador = jogador;
		this.acertos = acertos;
		this.erros = erros;
		this.dataDaPartida = data;
	}

	public String getJogador() {
		return jogador;
	}

	public void setJogador(String jogador) {
		this.jogador = jogador;
	}

	public int getAcertos() {
		return acertos;
	}

	public void setAcertos(int acertos) {
		this.acertos = acertos;
	}

	public int getErros() {
		return erros;
	}

	public void setErros(int erros) {
		this.erros = erros;
	}

	public LocalDate getDataDaPartida() {
		return dataDaPartida;
	}

	public void setDataDaPartida(LocalDate dataDaPartida) {
		this.dataDaPartida = dataDaPartida;
	}

}
