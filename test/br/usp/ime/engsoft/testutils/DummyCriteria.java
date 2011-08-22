package br.usp.ime.engsoft.testutils;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.impl.CriteriaImpl;

import br.usp.ime.engsoft.Search;

@SuppressWarnings("serial")
public class DummyCriteria extends CriteriaImpl{

	private List<Search> list;

	public DummyCriteria(List<Search> list) {
		super(null, null);
		this.list = list;
	}
	
	public List<Search> list() throws HibernateException {
		return list;
	}
}
