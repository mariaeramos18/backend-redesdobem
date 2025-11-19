package br.senac.rj.backend.dao;

import br.senac.rj.backend.entity.Organizacao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class OrganizacaoDao {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("backendPU2");

	public Organizacao salvar(Organizacao organizacao) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Organizacao OrganizacaoSalvo = em.merge(organizacao); // obter objeto completo salvo
			em.getTransaction().commit();
			return OrganizacaoSalvo;
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

	public Organizacao buscarPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Organizacao.class, id);
		} finally {
			em.close();
		}
	}
}
