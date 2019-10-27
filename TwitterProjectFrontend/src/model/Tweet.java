package model;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.TweetEntity;

@ManagedBean(name = "tweet")
@SessionScoped
public class Tweet implements Serializable{
	private static final long serialVersionUID = 1L;

	private String tweet;
	private String dateOfTweet;

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public String getDateOfTweet() {
		return dateOfTweet;
	}

	public void setDateOfTweet(String dateOfTweet) {
		this.dateOfTweet = dateOfTweet;
	}

	public TweetEntity getEntity() {
		TweetEntity tweetEntity = new TweetEntity();
		tweetEntity.setTweet(tweet);
		tweetEntity.setDateOfTweet(dateOfTweet);
		return tweetEntity;

	}

}
