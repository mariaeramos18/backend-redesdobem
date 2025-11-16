package br.senac.rj.backend.dao;

import br.senac.rj.backend.entity.Turma;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

import br.senac.rj.backend.entity.Doacao;

public class DoacaoDao {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("backendPU");

    public Doacao salvar(Doacao d) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Doacao doacaoSalva = em.merge(d);
            em.getTransaction().commit();
            return doacaoSalva;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    public Doacao buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Doacao.class, id);
        } finally {
            em.close();
        }
    }

    
}