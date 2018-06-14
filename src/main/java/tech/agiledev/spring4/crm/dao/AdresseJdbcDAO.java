package tech.agiledev.spring4.crm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdresseJdbcDAO extends AbstractJdbcDAO {

	@Autowired
	public AdresseJdbcDAO(JdbcTemplate template) {
		super(template);
	}
	
	public void deleteById(Long id) {
		this.template.update("DELETE FROM ADRESSE WHERE ID = ?", id);
	}
}
