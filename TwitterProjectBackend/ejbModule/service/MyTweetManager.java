package service;

import java.io.IOException;

import javax.servlet.ServletException;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class MyTweetManager {
	private static Twitter twitter;
	private static Status status;

	public static void startTweet( String userTweet) throws ServletException, TwitterException, IOException {

		System.out.println("Create Tweet" + userTweet);

		twitter = TwitterFactory.getSingleton();

		twitter.setOAuthConsumer("KUEaK4VIsyrRdEiOc7qBRWLRa", "A3ZbjJPc5xnXk2OGOYiF8XPaWFZ6AHPMFpLoOotK3a31aCXL0q");
		AccessToken accessToken = new AccessToken("153104802-lme4y5Xqzsrk2WC4YdH50M5ld0f3khPVyvIgVInJ",
				"cBdyXJtp7ZNkbQj6hTiwlaAovfkg2M8NiBgR7RNNBeIyS");
		twitter.setOAuthAccessToken(accessToken);

		status = twitter.updateStatus(userTweet);
		System.out.println("Successfully updated the status to [" + status.getText() + "].");
	}


}
