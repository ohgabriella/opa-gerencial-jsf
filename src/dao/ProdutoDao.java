package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Produto;
import util.ConnectionFactory;

public class ProdutoDao {
	
	public void salvar(Produto produto) {
		EntityManager em = ConnectionFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();		
		em.close();
	}
	
	public void atualizar (Produto produto) {
		EntityManager em = ConnectionFactory.getEntityManager();
		em.getTransaction().begin();
		em.merge(produto);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remover(Long id) {
		Produto p = new Produto();
		EntityManager em = ConnectionFactory.getEntityManager();
		em.getTransaction().begin();
		p= em.find(Produto.class, id);
		em.remove(p);
		em.getTransaction().commit();		
		em.close();
	}
	
	public List<Produto> listar(){
		List<Produto> produtos = null;
		String jpql = "SELECT p FROM Produto p";
		EntityManager em = ConnectionFactory.getEntityManager();
		TypedQuery<Produto> query = em.createQuery(jpql, Produto.class);
		produtos = query.getResultList();
		return produtos;
	}
	
	public Produto buscar(Long id) {
		EntityManager em = ConnectionFactory.getEntityManager();
		em.getTransaction().begin();
		Produto produto = em.find(Produto.class, id);
		em.getTransaction().commit();
		em.close();
		return produto;	
	}

}
