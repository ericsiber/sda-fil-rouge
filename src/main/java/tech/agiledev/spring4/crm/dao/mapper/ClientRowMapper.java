package tech.agiledev.spring4.crm.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import tech.agiledev.spring4.crm.modele.Client;

public class ClientRowMapper implements RowMapper<Client> {

	@Override
	public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
		Client client = new Client();
		client.setId(rs.getLong("ID"));
		client.setNom(rs.getString("NOM"));
		client.setPrenom(rs.getString("PRENOM"));
		return client;
	}

}
