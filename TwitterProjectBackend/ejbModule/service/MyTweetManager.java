package service;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class MyTweetManager {

	public void start(String userTweet) {

		// The factory instance is re-useable and thread safe.
		try {
			Twitter twitter = new TwitterFactory().getInstance();
			// Twitter twitter = TwitterFactory.getSingleton();
			Status status = twitter.updateStatus(userTweet);
			System.out.println("Successfully updated the status to [" + status.getText() + "].");

		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to get timeline: " + te.getMessage());
			System.exit(-1);
		}
	}

	private String getSavedAccessTokenSecret() {
		// consider this is method to get your previously saved Access Token
		// Secret
		return "????";
	}

	private String getSavedAccessToken() {
		// consider this is method to get your previously saved Access Token
		return "102333999-????";
	}

}
