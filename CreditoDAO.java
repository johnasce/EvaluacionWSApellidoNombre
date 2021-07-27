package ec.edu.ups.pw.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw.model.Credito;
import ec.edu.ups.pw.model.Factura;

@Stateless
public class CreditoDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Credito credito) {
		em.persist(credito);
		
	}
	
	public void update(Credito credito) {
		em.merge(credito);
	}
	
	public Credito read(int id) {
		Credito c = em.find(Credito.class, id);
		return c;
	}
	
	public void delete (int id) {
		Credito c = em.find(Credito.class, id);
		em.remove(c);
	}
	
	public List<Credito> getFacturas(String nombre) {
		/*
		 * String jpql = "SELECT c FROM Cliente " + "WHERE cli_nombre 'Juan'";
		 */
		// Esta mal; debemos pensar los nombres que esten en el java.

		String jpq2 = "SELECT f FROM Credito f " ;
		Query query = em.createQuery(jpq2, Credito.class);
		
		List<Credito> creditos = query.getResultList();
		return creditos;
		
	}
	
}
