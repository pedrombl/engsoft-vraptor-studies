package br.usp.ime.engsoft;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;


import org.junit.Before;
import org.junit.Test;

import br.usp.ime.engsoft.testutils.DummyTweet;

import twitter4j.QueryResult;
import twitter4j.Tweet;

public class TestSearch {

	
	private Search search;


	@Before
	public void createSearchObject() {
		search = new Search();
		search.setId(new Long(1));
		search.setWord("test word");
	}
	
	@Test
	public void shouldHaveAnId() {
		assertEquals(new Long(1), search.getId());
	}
	
	@Test
	public void shouldHaveAWord() throws Exception {
		assertEquals("test word", search.getWord());
	}
	
	@Test
	public void shouldReturnNoMoreThan5Tweets() throws Exception {
		QueryResult result = mock(QueryResult.class);
		when(result.getTweets()).thenReturn(giveTweets(10));
		assertEquals(5, search.getTweets().size());
	}
	
	
	private List<Tweet> giveTweets(int n) {
		List<Tweet> tweets = new ArrayList<Tweet>();
		for (int i = 0; i < n; i++) {
			tweets.add(new DummyTweet());
		}
		return tweets;
	}


}
