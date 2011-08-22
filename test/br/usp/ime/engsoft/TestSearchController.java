package br.usp.ime.engsoft;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.Result;
import br.usp.ime.engsoft.dao.SearchDao;

public class TestSearchController {

	private SearchDao dao;
	private SearchController controller;

	@Before
	public void createObjects() {
		dao = mock(SearchDao.class);
		Result result = mock(Result.class);
		controller = new SearchController(result, dao);
		when(result.redirectTo(SearchController.class)).thenReturn(controller);
	}

	@Test
	public void shouldReturnAListOfSearches() {
		List<Search> list = new ArrayList<Search>();
		list.add(new Search());
		list.add(new Search());

		when(dao.getList()).thenReturn(list);
		assertEquals(2, controller.index().size());
	}

	@Test
	public void shouldSaveAnSearchObjectCorrectly() throws Exception {
		Search search = new Search();

		controller.save(search);
		verify(dao).save(search);
	}

	@Test
	public void afterSavingAnSearchObjectItShouldRedirectToIndex()
			throws Exception {
		Search search = new Search();

		controller.save(search);
		verify(dao).getList(); // method that is called when called index method
	}

	@Test
	public void shouldReturnCorrectObjectWhenCallEditMethod() throws Exception {
		Long id = new Long(1);
		controller.edit(id);
		verify(dao).get(id);
	}

	@Test
	public void shouldUpdateObjectInDatabaseWhenCalledUpdateMethod()
			throws Exception {
		Search search = new Search();
		controller.update(search);
		verify(dao).update(search);
	}

	@Test
	public void shouldRedirectToIndexAfterUpdate() throws Exception {
		Search search = new Search();
		controller.update(search);
		verify(dao).getList();
	}

	@Test
	public void shouldGetCorrectSearchObjectBeforeRemovingIt() throws Exception {
		Long id = new Long(1);
		Search search = new Search();
		when(dao.get(id)).thenReturn(search);

		controller.remove(id);
		verify(dao).get(id);
	}

	@Test
	public void shouldRemoveSearchObjectWithSameId() throws Exception {
		Long id = new Long(1);
		Search search = new Search();
		when(dao.get(id)).thenReturn(search);

		controller.remove(id);
		verify(dao).remove(search);
	}

	@Test
	public void shouldRedirectToIndexAfterRemove() throws Exception {
		Long id = new Long(1);
		Search search = new Search();
		when(dao.get(id)).thenReturn(search);

		controller.remove(id);
		verify(dao).getList();
	}

	@Test
	public void shouldReturnCorrectSearchWhenCalledShowMethod()
			throws Exception {
		Long id = new Long(1);
		controller.show(id);
		verify(dao).get(id);
	}

}
