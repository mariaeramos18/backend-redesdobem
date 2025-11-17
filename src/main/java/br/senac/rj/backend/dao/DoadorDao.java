package br.senac.rj.backend.dao;

import br.senac.rj.backend.entity.Doador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DoadorDao {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("backendPU2");

	public Doador salvar(Doador doador) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Doador EventoSalvo = em.merge(doador); // obter objeto completo salvo
			em.getTransaction().commit();
			return EventoSalvo;
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback(); // desfazer transações pendentes
			}
			e.printStackTrace(); // Para depuração
			return null;
		} finally {
			em.close();
		}
	}

	public Doador buscarPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Doador.class, id);
		} finally {
			em.close();
		}
	}
}
