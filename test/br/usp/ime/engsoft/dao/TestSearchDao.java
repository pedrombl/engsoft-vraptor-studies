package br.usp.ime.engsoft.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import br.usp.ime.engsoft.Search;
import br.usp.ime.engsoft.testutils.DummyCriteria;
import br.usp.ime.engsoft.testutils.DummyTransaction;

public class TestSearchDao {

	private Session session;
	private Search search;
	private SearchDao dao;
	private DummyTransaction tx;

	@Before
	public void createMocksAndObjects() {
		session = mock(Session.class);
		tx = new DummyTransaction();
		when(session.beginTransaction()).thenReturn(tx);
		search = createSearchObject();
		dao = new SearchDao(session);
	}

	private Search createSearchObject() {
		Search search = new Search();
		search.setId(new Long(1));
		search.setWord("test word");
		return search;
	}

	@Test
	public void shouldBeginATransactionBeforeSavingASearchObject() {
		dao.save(search);
		verify(session).beginTransaction();
	}

	@Test
	public void shouldSaveCorrectlyASearchObject() throws Exception {
		dao.save(search);
		verify(session).save(search);
	}

	@Test
	public void shouldCommitATransactionAfterSaveASearchObject() {
		dao.save(search);
		assertTrue(tx.wasCommitted());
	}

	@Test
	public void shouldBeginATransactionBeforeRemovingASearchObject() {
		dao.remove(search);
		verify(session).beginTransaction();
	}

	@Test
	public void shouldRemoveCorrectlyASearchObject() throws Exception {
		dao.remove(search);
		verify(session).delete(search);
	}

	@Test
	public void shouldCommitATransactionAfterRemoveASearchObject() {
		dao.remove(search);
		assertTrue(tx.wasCommitted());
	}

	@Test
	public void shouldBeginATransactionBeforeUpdatingASearchObject() {
		dao.update(search);
		verify(session).beginTransaction();
	}

	@Test
	public void shouldUpdateCorrectlyASearchObject() throws Exception {
		dao.update(search);
		verify(session).update(search);
	}

	@Test
	public void shouldCommitATransactionAfterUpdateASearchObject() {
		dao.update(search);
		assertTrue(tx.wasCommitted());
	}

	@Test
	public void shouldReturnAListOfTheSearchObjects() throws Exception {
		List<Search> list = new ArrayList<Search>();
		list.add(search);
		Search search2 = new Search();
		search2.setId(new Long(10));
		list.add(search2);

		DummyCriteria criteria = new DummyCriteria(list);
		when(session.createCriteria(Search.class)).thenReturn(criteria);
		
		assertEquals(2, dao.getList().size());
		
	}

	@Test
	public void shouldCallTheCorrectMethodToFindASpecificSearchObject()
			throws Exception {
		Long id = new Long(1);
		dao.get(id);
		verify(session).load(Search.class, id);
	}

}
