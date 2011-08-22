package br.usp.ime.engsoft;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

// Here, each search records the word that the user wants to use
// and how to search this word

@Entity
public class Search {

	@Id
	@GeneratedValue
	private Long id;
	private String word;

	public Search() {
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// Return the last 5 tweets mentioning the word "word"
	public List<Tweet> getTweets() throws TwitterException {
		Twitter twitter = new TwitterFactory().getInstance();
		QueryResult result = twitter.search(new Query(word));

		List<Tweet> tweets = result.getTweets();

		if (tweets.size() < 5)
			return tweets;
		return result.getTweets().subList(0, 5);
	}

}
