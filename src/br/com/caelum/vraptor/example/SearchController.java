/***
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.caelum.vraptor.example;

import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

//Controller of the searches
@Resource
public class SearchController {
	
	private final Result result;
	private Searches searches;

	public SearchController(Result result, Searches searches) {
		this.result = result;
		this.searches = searches;
	}

	@Path("/")
	public List<Search> index() {
		return searches.getList();
	}
	
	public void create() {
	}
	
	
	public void save(final Search search) {
		searches.add(search);
		result.redirectTo(SearchController.class).index();
	}
	
	@Path("/search/{id}/edit")
	public Search edit(Long id) {
		return searches.getSearch(id);
	}
	
	@Path("/search/{search.id}/update")
	public void update(Search search) {
		searches.update(search);
		result.redirectTo(SearchController.class).index();
	}


	public void remove(Long id) {
		Search search = searches.getSearch(id);
		searches.remove(search);
		result.redirectTo(SearchController.class).index();
	}
	
	@Path("/search/{id}")
	public Search show(Long id) {
		return searches.getSearch(id);
	}
	
	

}
