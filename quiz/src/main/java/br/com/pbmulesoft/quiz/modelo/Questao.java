package br.com.pbmulesoft.quiz.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTÕES")
public class Questao {

	@Id
	@GeneratedValue
	private Long id;
	private String questao;
	private boolean verdadeira;
	private boolean ativa;

	public Questao() {
	}
	
	public Questao(String questao, boolean verdadeira) {
		this.questao = questao;
		this.verdadeira = verdadeira;
	}

	public String getQuestao() {
		return questao;
	}

	public void setQuestao(String questao) {
		this.questao = questao;
	}

	public boolean isVerdadeira() {
		return verdadeira;
	}

	public void setVerdadeira(boolean verdadeira) {
		this.verdadeira = verdadeira;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

}