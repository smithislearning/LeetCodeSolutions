public class Twitter {

    private HashMap<Integer, HashSet<Integer>> acntF;

    private HashMap<Integer, Integer> posts;

    private LinkedList<Integer> postIds;



    /** Initialize your data structure here. */

    public Twitter() {

        acntF = new HashMap<Integer, HashSet<Integer>>();

        posts = new HashMap<Integer, Integer>();

        postIds = new LinkedList<Integer>();

    }

    

    /** Compose a new tweet. */

    public void postTweet(int userId, int tweetId) {

        if(!acntF.containsKey(userId)) {

            acntF.put(userId, new HashSet<Integer>());

        }

        posts.put(tweetId, userId);

        postIds.add(tweetId);

    }

    

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */

    public List<Integer> getNewsFeed(int userId) {

        int count = 0;

        ArrayList<Integer> rst = new ArrayList<Integer>();

        if(!acntF.containsKey(userId)) {

            acntF.put(userId, new HashSet<Integer>());

            return rst;

        }

        Iterator<Integer> itr = postIds.descendingIterator();

        while(itr.hasNext() && count < 10) {

            int postId = itr.next();

            int posterId = posts.get(postId);

            if(userId == posterId || acntF.get(userId).contains(posterId)) {

                rst.add(postId);

                count ++;

            }

        }

        return rst;

    }

    

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */

    public void follow(int followerId, int followeeId) {

        if(followerId == followeeId) {

            return;

        }

        if(!acntF.containsKey(followeeId)) {

            acntF.put(followeeId, new HashSet<Integer>());

        }

        if(!acntF.containsKey(followerId)) {

            acntF.put(followerId, new HashSet<Integer>());

        }

        acntF.get(followerId).add(followeeId);

    }

    

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */

    public void unfollow(int followerId, int followeeId) {

        if(followerId == followeeId || !acntF.containsKey(followerId) || !acntF.containsKey(followeeId)) {

            return;

        }

        acntF.get(followerId).remove(followeeId);

    }

}



/**

 * Your Twitter object will be instantiated and called as such:

 * Twitter obj = new Twitter();

 * obj.postTweet(userId,tweetId);

 * List<Integer> param_2 = obj.getNewsFeed(userId);

 * obj.follow(followerId,followeeId);

 * obj.unfollow(followerId,followeeId);

 */
