package ec.edu.ups.pw.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.pw.model.Persona;



@Stateless
public class PersonaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Persona cliente) {
		em.persist(cliente);
		
	}
	
	public void update(Persona cliente) {
		em.merge(cliente);
	}
	
	public Persona read(String cedula) {
		Persona c = em.find(Persona.class, cedula);
		return c;
	}
	
	public void delete (String cedula) {
		Persona c = em.find(Persona.class, cedula);
		em.remove(c);
	}
	
	public List<Persona> getClientes(String nombre) {
		/*
		 * String jpql = "SELECT c FROM Cliente " + "WHERE cli_nombre 'Juan'";
		 */
		// Esta mal; debemos pensar los nombres que esten en el java.

		String jpq2 = "SELECT c FROM Persona c " 
					+ "WHERE nombre LIKE ?1 ";

		nombre = nombre + "%";
		Query query = em.createQuery(jpq2, Persona.class);
		query.setParameter(1, nombre);
		
		List<Persona> clientes = query.getResultList();
		return clientes;
		
	}
}
