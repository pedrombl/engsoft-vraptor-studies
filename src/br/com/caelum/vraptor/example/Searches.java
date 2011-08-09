package br.com.caelum.vraptor.example;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

//Keep the words that the user created during the application scope
@Component
@ApplicationScoped
public class Searches {
	private List<Search> searchList = new ArrayList<Search>();
	
	public void add(Search search) {
		searchList.add(search);
	}
	
	public List<Search> getList() {
		return searchList;
	}

	public void remove(Search search) {
		searchList.remove(search);
	}
	
	public Search getSearch(long id) {
		for (Search search : searchList) {
			if(search.getId() == id)
				return search;
		}
		return null;
	}

	public void update(Search search) {
		Search searchAntigo = getSearch(search.getId());
		remove(searchAntigo);
		add(search);
	}
	
}
