package br.usp.ime.engsoft.utils;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class TestSessionCreation {

	@Test
	public void shouldGetASession() {
		SessionFactory factory = mock(SessionFactory.class);
		Configuration conf = mock(Configuration.class);
		stub(conf.buildSessionFactory()).toReturn(factory);
		SessionCreation.setConf(conf);

		SessionCreation.getSession();
		verify(factory).openSession();
	}

}
