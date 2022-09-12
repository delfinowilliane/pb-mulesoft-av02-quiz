package br.com.pbmulesoft.quiz.menu;

import java.util.List;

import javax.persistence.EntityManager;

import DAO.QuestaoDao;
import br.com.pbmulesoft.quiz.modelo.Questao;
import br.com.pbmulesoft.quiz.util.JPAUtil;

public class SelecionarQuestoes {

	EntityManager em = JPAUtil.getEntityManager();
	QuestaoDao questaoDao = new QuestaoDao(em);

	public String[] SelecaoQuestoes() {

		List<Questao> todas = questaoDao.todasAsQuestoes();
		String[] selecao = new String[todas.size()];

		for (int i = 0; i < todas.size(); i++) {
			selecao[i] = todas.get(i).getQuestao();

		}
		return selecao;
	}
}
