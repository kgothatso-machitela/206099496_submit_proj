package service;

import twitter4j.*;
import twitter4j.Status;


import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class MyTweetManager {

	public void start(String userTweet) {

			System.out.println("Create Tweet" + userTweet );

			Twitter twitter = TwitterFactory.getSingleton();
			twitter.setOAuthConsumer("KUEaK4VIsyrRdEiOc7qBRWLRa", "A3ZbjJPc5xnXk2OGOYiF8XPaWFZ6AHPMFpLoOotK3a31aCXL0q");
			AccessToken accessToken = new AccessToken("153104802-lme4y5Xqzsrk2WC4YdH50M5ld0f3khPVyvIgVInJ", "cBdyXJtp7ZNkbQj6hTiwlaAovfkg2M8NiBgR7RNNBeIyS")
			twitter.setOAuthAccessToken(accessToken);
			Status status = twitter.updateStatus(userTweet);
			System.out.println("Successfully updated the status to [" + status.getText() + "].");


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
