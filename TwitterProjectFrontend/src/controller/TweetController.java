package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.servlet.ServletException;

import model.Tweet;
import service.MyTweetManager;
import service.TweetEJB;
import twitter4j.TwitterException;

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
	public void addNewTweet() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd 'T' HH:mm:ss");
	    Date date = new Date();

	    String dateString = java.time.LocalDate.now().toString() + 'T' + java.time.LocalTime.now().toString();

		tweet.setDateOfTweet(dateString);

		tweetEJB.addNew(tweet.getEntity());

		tweetList = tweetEJB.findTweets();

		sendTweet();

		//return "tweetlist.xhtml";
	}

	public void sendTweet(){
		System.out.println("trying to send tweet");

		try {

			MyTweetManager.startTweet("@AdhLecturer tweeted from my approved dev access account");
		} catch (ServletException | TwitterException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}
