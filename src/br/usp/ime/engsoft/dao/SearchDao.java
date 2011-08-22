package br.usp.ime.engsoft.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.usp.ime.engsoft.Search;
import br.usp.ime.engsoft.utils.SessionCreation;

@Component
public class SearchDao {
	private Session session;

	public SearchDao() {
		this.session = SessionCreation.getSession();
	}
	
	public SearchDao(Session session) {
		this.session = session;
	}
	
	public void save(Search search) {
		Transaction tx = session.beginTransaction();
		session.save(search);
		tx.commit();
	}
	
	public void remove(Search search) {
		Transaction tx = session.beginTransaction();
		session.delete(search);
		tx.commit();		
	}
	
	public void update(Search search) {
		Transaction tx = session.beginTransaction();
		session.update(search);
		tx.commit();			
	}
	
	@SuppressWarnings("unchecked")
	public List<Search> getList() {
		return session.createCriteria(Search.class).list();
	}
	
	public Search get(Long id) {
		return (Search) this.session.load(Search.class, id);
	}
}
