package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Lance;
import util.JPAUtil;

public class LanceDao {

	public static void salvar(Lance l) {
		EntityManager em = JPAUtil.criarEM();
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}

	public static void editar(Lance l) {
		EntityManager em = JPAUtil.criarEM();
		em.getTransaction().begin();
		em.merge(l);
		em.getTransaction().commit();
		em.close();
	}

	public static void excluir(Lance l) {
		EntityManager em = JPAUtil.criarEM();
		em.getTransaction().begin();
		l = em.find(Lance.class, l.getId());
		em.remove(l);
		em.getTransaction().commit();
		em.close();
	}

	public static List<Lance> listar() {
		EntityManager em = JPAUtil.criarEM();
		Query q = em.createQuery("select l from Lance l");
		@SuppressWarnings("unchecked")
		List<Lance> resultado = q.getResultList();
		em.close();
		return resultado;
	}
}
