package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import model.Tweet;
import service.MyTweetManager;
import service.TweetEJB;

@ManagedBean(name = "tweetcontroller")
@SessionScoped
public class TweetController {

	@EJB
	private TweetEJB tweetEJB;

	@ManagedProperty(value = "#{tweet}")
	private Tweet tweet;

	private MyTweetManager myTweeter;

	private List<Tweet> tweetList = new ArrayList<>();

	public List<Tweet> getTweetList() {
		tweetList = tweetEJB.findTweets();
		return tweetList;
	}

	public Tweet getTweet() {
		return tweet;
	}

	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}

	@SuppressWarnings("unchecked")
	public String addNewTweet() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd 'T' HH:mm:ss");
	    Date date = new Date();

	    String dateString = java.time.LocalDate.now().toString() + 'T' + java.time.LocalTime.now().toString();

		tweet.setDateOfTweet(dateString);

		tweetEJB.addNew(tweet.getEntity());


		myTweeter.start("@AdhLecturer tweeted from my approved dev access account");

		tweetList = tweetEJB.findTweets();

		return "tweetlist.xhtml";
	}



}
