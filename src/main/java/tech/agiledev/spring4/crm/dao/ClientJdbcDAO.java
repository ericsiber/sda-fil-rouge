package tech.agiledev.spring4.crm.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tech.agiledev.spring4.crm.Application;
import tech.agiledev.spring4.crm.dao.mapper.ClientRowMapper;
import tech.agiledev.spring4.crm.modele.Client;

/**
 * Version prise en main
 *
 */
@Repository
@CacheConfig(cacheNames = {"client"})
public class ClientJdbcDAO {

	private static Logger LOGGER = LoggerFactory.getLogger(ClientJdbcDAO.class);
	
	private DataSource dataSource;

	@Autowired
	public ClientJdbcDAO(DataSource ds) {
		this.dataSource = ds;
	}
	
	@Cacheable
	public List<Client> findAll() {
		LOGGER.debug("Running findAll");
		JdbcTemplate template = new JdbcTemplate(dataSource);
		// on déclare le Mapper à part plutôt que d'en faire une classe anonyme
		return template.query("SELECT * FROM CLIENT", new ClientRowMapper());
	}

	public List<Client> findAllJava8() {
		JdbcTemplate template = new JdbcTemplate(dataSource);
		// Java 8
		return template.query("SELECT * FROM CLIENT", 
				(rs, rowNum) -> {
					Client client = new Client();
					client.setId(rs.getLong("ID"));
					client.setNom(rs.getString("NOM"));
					client.setPrenom(rs.getString("PRENOM"));
					return client;
					}
			);
	}

}
