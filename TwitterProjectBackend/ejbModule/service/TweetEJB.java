package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SessionFactory;

import entities.TweetEntity;

@Stateless
@LocalBean
public class TweetEJB<Tweet> {
	SessionFactory sessionFactory;

	@PersistenceContext
	private EntityManager em;


	public TweetEJB() {

	}

	public void addNew(TweetEntity tweetEntity) {
		System.out.println("============================");
		System.out.println( tweetEntity.getTweet() );
		em.persist(tweetEntity);
		System.out.println("============================");
	}

	@SuppressWarnings("rawtypes")
	public List findTweets() {
	// TODO Auto-generated method stub
		System.out.println("======Reading Tweets=======");

		Query queryObj = em.createQuery("SELECT t FROM twitter_tbl t");
		List tweetList =  queryObj.getResultList();
		System.out.println("=======End of Reading Tweets=========");
		if (tweetList != null && tweetList.size() > 0) {
			return tweetList;
		} else {
			return null;
		}

	}

}
