package br.usp.ime.engsoft.testutils;

import javax.transaction.Synchronization;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

public class DummyTransaction implements Transaction {

	private boolean commit = false;
	
	public void commit() throws HibernateException {
		commit  = true;
	}

	public boolean wasCommitted() throws HibernateException {
		return commit;
	}

	public void begin() throws HibernateException {
		// TODO Auto-generated method stub
		
	}

	public boolean isActive() throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	public void registerSynchronization(Synchronization arg0)
			throws HibernateException {
		// TODO Auto-generated method stub
		
	}

	public void rollback() throws HibernateException {
		// TODO Auto-generated method stub
		
	}

	public void setTimeout(int arg0) {
		// TODO Auto-generated method stub
		
	}

	public boolean wasRolledBack() throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}
}
