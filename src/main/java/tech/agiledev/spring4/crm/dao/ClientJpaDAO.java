package tech.agiledev.spring4.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import tech.agiledev.spring4.crm.modele.Client;

@Repository
public class ClientJpaDAO {
	
	@PersistenceContext
	// déclaration explicite si plusieurs unités de persistence
	//@PersistenceContext(unitName = "crm-pu")
	private EntityManager em;

	public ClientJpaDAO() {
		super();
	}
	
	public List<Client> findAll() {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("crm-pu");
//		EntityManager em = emf.createEntityManager();
		return em.createQuery("select c from Client c", Client.class).getResultList();
	}
}
