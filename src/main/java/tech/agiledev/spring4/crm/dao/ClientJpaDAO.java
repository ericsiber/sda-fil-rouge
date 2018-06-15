package tech.agiledev.spring4.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tech.agiledev.spring4.crm.modele.Client;

@Repository
public class ClientJpaDAO {

	@PersistenceContext
	private EntityManager em;

	public ClientJpaDAO() {
		super();
	}

	public List<Client> findAll() {
		return em.createQuery("select c from Client c join fetch c.adresse a join fetch c.commandes", Client.class)
				.getResultList();
	}

	public void deleteByAdresseId(Long adresseId) {
		Query query = em.createQuery("delete from Client c where c.adresse.id = :id");
		query.setParameter("id", adresseId);
		query.executeUpdate();
	}

	public Client findById(Long id) {
		Client c = em.find(Client.class, id);
		// forcage du chargement pour démo REST
		c.getAdresse();
		c.getCommandes().size();
		return c;
	}
}
