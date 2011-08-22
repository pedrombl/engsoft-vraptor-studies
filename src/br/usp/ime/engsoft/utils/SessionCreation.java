package br.usp.ime.engsoft.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionCreation {

	private static SessionFactory sessionFactory = null;
	private static Configuration conf = null;

	public static Session getSession() {
		if (sessionFactory == null)
			createSessionFactory();
		return sessionFactory.openSession();
	}

	private static void createSessionFactory() {
		if (conf == null)
			createConf();
		conf.configure();
		sessionFactory = conf.buildSessionFactory();
	}

	private static void createConf() {
		conf = new Configuration();
	}

	public static void setConf(Configuration conf) {
		SessionCreation.conf = conf;
	}
}
