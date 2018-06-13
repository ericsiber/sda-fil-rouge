package tech.agiledev.spring4.crm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import tech.agiledev.spring4.crm.modele.Commande;

/**
 * Version plus rationnalisée (usage récurrent de JdbcTemplate)
 *
 */
@Repository
public class CommandeJdbcDAO extends AbstractJdbcDAO {

	@Autowired
	public CommandeJdbcDAO(JdbcTemplate template) {
		super(template);
	}
	
	public List<Commande> findAllByClientId(Long id) {
		return this.template.query("SELECT * FROM COMMANDE WHERE CLIENT_ID = ? ", new Object[] { id },
				new RowMapper<Commande>() {

					@Override
					public Commande mapRow(ResultSet rs, int rowNum) throws SQLException {
						Commande c = new Commande();
						c.setMontant(rs.getLong("MONTANT"));
						return c;
					}

				});
	}
}
