package tech.agiledev.spring4.crm.service;

import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration("classpath:test-applicationContext.xml")
// Dans une classe de test, permet d'exécuter chaque cas de test dans un
// contexte transactionnel isolé
// Après chaque cas de test Spring se charge de faire un rollback
@Transactional
@RunWith(SpringRunner.class)
public class ClientServiceTest {

	@Autowired
	private ClientService clientService;

	@Test(expected = AuthenticationCredentialsNotFoundException.class)
	public void no_authenticated_user_should_not_run_clientService() {
		clientService.deleteClientById(1L);
	}

	@Test
	@WithUserDetails("eric")
	public void user_eric_should_run_clientService() {
		clientService.deleteClientById(1L);
		// en toute rigueur, je devrais tester en exécutant une requête SQL et non
		// réutiliser mon service / dao. Le problème est qu'avec JPA il faut s'assurer
		// que les ordres SQL ont été envoyés à la base pour pouvoir disposer d'un état
		// cohérent
		assertNull(clientService.findById(1L));
	}

	@Test(expected = AccessDeniedException.class)
	@WithMockUser(username = "other", authorities = { "ROLE_USER" })
	public void user_with_user_role_should_not_run_clientService() {
		clientService.deleteClientById(1L);
	}

	@Test(expected = AccessDeniedException.class)
	@WithAnonymousUser
	public void anonymous_user_should_not_run_clientService() {
		clientService.deleteClientById(1L);
	}

}
