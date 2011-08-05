package br.com.caelum.vraptor.example;

import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class Search {
	
	private String word;
	private long id;

	public Search() {
		this.id = System.currentTimeMillis();
	}
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public List<Tweet> getTweets() throws TwitterException {
		Twitter twitter = new TwitterFactory().getInstance();
		QueryResult result = twitter.search(new Query(word));
		
		List<Tweet> tweets = result.getTweets();
		
		if(tweets.size() < 5)
			return tweets;
		return result.getTweets().subList(0, 5);
	}

}
