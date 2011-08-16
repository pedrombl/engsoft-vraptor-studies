package br.usp.ime.engsoft.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionCreation {


	private static SessionFactory sessionFactory = null;
	
	public static Session getSession() {
		if(sessionFactory == null)
			createSessionFactory();
		return sessionFactory.openSession();
	}
	

	private static void createSessionFactory() {
		Configuration conf = new Configuration();
		conf.configure();
		sessionFactory = conf.buildSessionFactory();
	}
}
