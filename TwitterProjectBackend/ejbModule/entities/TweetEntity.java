package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="twitter_tbl")
public class TweetEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private Long id;

	@Column(name= "tweet")
	private String tweet;

	@Column(name="dateOfTweet" )
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


}
