package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.pbmulesoft.quiz.modelo.Resultado;

public class ResultadoDao {

private EntityManager em;
	
	public ResultadoDao(EntityManager em) {
		this.em = em;
	}
	
	public void salvar(Resultado resultado) {
		this.em.persist(resultado);
	}
	
	public List<Resultado> buscarResultadoDecrescente(){
		String jpql = "SELECT r FROM Resultado r ORDER BY acertos DESC";
		return em.createQuery(jpql, Resultado.class).getResultList();		
	}
}
