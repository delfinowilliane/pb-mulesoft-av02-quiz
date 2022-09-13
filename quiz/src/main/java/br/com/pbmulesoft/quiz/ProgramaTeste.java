package br.com.pbmulesoft.quiz;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import DAO.QuestaoDao;
import DAO.ResultadoDao;
import br.com.pbmulesoft.quiz.modelo.Questao;
import br.com.pbmulesoft.quiz.modelo.Resultado;
import br.com.pbmulesoft.quiz.util.JPAUtil;

public class ProgramaTeste {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Seja bem vindo ao fandom quiz sobre Harry Potter");
			System.out.println();
			System.out.println("Opções: ");
			System.out.println("1 - Jogar");
			System.out.println("2 - Ver Placar");
			System.out.println("0 - Sair");
			int escolha = scan.nextInt();
						
			EntityManager em = JPAUtil.getEntityManager();
			Resultado jogador = new Resultado();
			ResultadoDao resultadoDao = new ResultadoDao(em);
			ResultadoDao verPlacar = new ResultadoDao(em);
			
			switch (escolha) {
			case 1: 
				System.out.println("Nome do jogador: ");
				jogador.setJogador(scan.next());

				jogador.setAcertos(0);
				jogador.setErros(0);

				QuestaoDao questaoDao = new QuestaoDao(em);
				List<Questao> selecionarQuestoes = questaoDao.todasAsQuestoes();

				selecionarQuestoes.forEach(pergunta -> {
					System.out.println("Verdadeiro(v) ou Falso(f)? Responda com a letra correspondente: "
							+ pergunta.getQuestao());
					String resposta = scan.next().toLowerCase();

					boolean setResposta = true;

					if (resposta == "v") {
						setResposta = true;
						if (setResposta = true) {
							pergunta.isVerdadeira();
							jogador.setAcertos(jogador.getAcertos() + 1);
						}
					} else if (resposta == "f") {
						setResposta = false;
						if (setResposta = false) {
							jogador.setErros(jogador.getErros() + 1);
						}
					} else if (resposta != "v" || resposta != "f") {
						System.out.println("Opção inexistente");
					}

				});
			
				em.getTransaction().begin();
				resultadoDao.salvar(jogador);
				em.getTransaction().commit();

				break;
			case 2:

				List<Resultado> placar = verPlacar.buscarResultadoDecrescente();

				placar.forEach(nome -> {
					System.out.println("JOGADOR: " + nome.getJogador() + "ACERTOS: " + nome.getAcertos() + "ERROS: "
							+ nome.getErros() + "DATA: " + nome.getDataDaPartida());
				});
				break;
			case 0:
				System.out.println("Saindo do jogo...");
				break;
			default:
				System.out.println("Tente novamente!");
			}
			
		}
	}
}
