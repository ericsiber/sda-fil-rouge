package tech.agiledev.spring4.crm.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractJdbcDAO {
	protected JdbcTemplate template;

	public AbstractJdbcDAO(JdbcTemplate template) {
		this.template = template;
	}
}
