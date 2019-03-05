import javafx.util.Pair;
import java.util.*;

public class Design_355 {
	class Tweet {
        int tweetId;
        int timeStamp;
        
        Tweet(int _tId, int _tSp) {
            tweetId = _tId;
            timeStamp = _tSp;
        }
    }
    
    int size;
    Map<Integer, List<Tweet>> tweets;
    Map<Integer, Set<Integer>> follows;

    /** Initialize your data structure here. */
    public Design_355() {
        size = 0;
        tweets = new HashMap<>();
        follows = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, size++);
        tweets.putIfAbsent(userId, new LinkedList<>());
        tweets.get(userId).add(0, tweet);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Pair<Tweet, Iterator<Tweet>>> maxHeap = new PriorityQueue<>(Comparator.comparing((Pair<Tweet, Iterator<Tweet>> pair) -> -pair.getKey().timeStamp));
        
        if (tweets.containsKey(userId) && !tweets.get(userId).isEmpty()) {
            Iterator<Tweet> it = tweets.get(userId).iterator();
            maxHeap.add(new Pair<>(it.next(), it));
        }
        
        // Some userId may not follow anyone
        // If we do not add if here, we will get NullPointException
        if (follows.containsKey(userId)) {
        	for (int followee : follows.get(userId)) {
        		// Some user can follow himself in the testcases, so we must check followee != userId
        		// Otherwise, we will add duplicates people in the heap
	            if (followee != userId && tweets.containsKey(followee) && !tweets.get(followee).isEmpty()) {
	                Iterator<Tweet> it = tweets.get(followee).iterator();
	                maxHeap.add(new Pair<>(it.next(), it));
	            }
	        }	
        }
        
        List<Integer> res = new ArrayList<>();
        while (res.size() < 10 && !maxHeap.isEmpty()) {
            Pair<Tweet, Iterator<Tweet>> pair = maxHeap.poll();
            res.add(pair.getKey().tweetId);
            Iterator<Tweet> it = pair.getValue();
            if (it.hasNext()) 
                maxHeap.add(new Pair<>(it.next(), it));
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }


    public static void main(String[] args) {
    	Design_355 twitter = new Design_355();
    	twitter.postTweet(1, 5);
    	twitter.getNewsFeed(1);
    	twitter.follow(1, 2);
    	twitter.postTweet(2, 6);
    	List<Integer> res = twitter.getNewsFeed(1);
    	System.out.println(res.get(0) + " " + res.get(1) + " " + res.size());
    }
}