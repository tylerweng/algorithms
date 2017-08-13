import time

def insertTweets(newFolloweeTweets, feed):
    m = len(newFolloweeTweets)
    n = len(feed)
    i = 0
    j = 0
    while i < m and j < n:
        iTweet = newFolloweeTweets[i]
        jTweet = feed[j]
        if iTweet["time"] < jTweet["time"]:
            feed.insert(j, iTweet)
            i += 1
            n += 1
        else:
            j += 1
    feed += newFolloweeTweets[i:]

class Twitter(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.users = {}
        self.tweets = {}

        '''
        user schema
          {
            userId:  int,
            following: userId[],
            followers: userId[],
            feed: tweet[] where userId in following
          }
        '''

        '''
        tweet schema 
          {
            userId: int,
            tweetId: int,
            time: time obj
          }
        '''


    def postTweet(self, userId, tweetId):
        """
        Compose a new tweet.
        :type userId: int
        :type tweetId: int
        :rtype: void
        """
        try:
            user = self.users[userId]
        except KeyError:
            # create user
            self.createUser(userId)
            user = self.users[userId]
        followers = user["followers"]
        feed = user["feed"]
        for followerId in followers:
            self.users[followerId]["feed"].append({"tweetId": tweetId, "userId": userId, "time": time.time()})
        feed.append({"tweetId": tweetId, "userId": userId, "time": time.time()})

    def createUser(self, userId):
        self.users[userId] = {
            "userId": userId,
            "following": [],
            "followers": [],
            "feed": []
        }


    def getNewsFeed(self, userId):
        """
        Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
        :type userId: int
        :rtype: List[int]
        """
        try:
            user = self.users[userId]
        except KeyError:
            return []
        feed = user["feed"]
        lim = min(10, len(feed)) + 1
        tweetIds = []
        for i in xrange(-1, -lim, -1):
            tweetIds.append(feed[i]["tweetId"])
        return tweetIds


    def follow(self, followerId, followeeId):
        """
        Follower follows a followee. If the operation is invalid, it should be a no-op.
        :type followerId: int
        :type followeeId: int
        :rtype: void
        """
        try:
            followee = self.users[followeeId]
        except KeyError:
            self.createUser(followeeId)
            followee = self.users[followeeId]

        try:
            follower = self.users[followerId]
        except KeyError:
            self.createUser(followerId)
            follower = self.users[followerId]

        if followerId == followeeId:
            return

        if followerId not in followee["followers"]:
            followee["followers"].append(followerId)
            follower["following"].append(followeeId)
            # add followee tweets to follower feed
            followeeTweets = filter(lambda t: t["userId"] == followeeId, followee["feed"])
            followerFeed = follower["feed"]
            # followerFeed += followeeTweets
            # followerFeed.sort(key = lambda t: t["time"])
            insertTweets(followeeTweets, followerFeed)

    def unfollow(self, followerId, followeeId):
        """
        Follower unfollows a followee. If the operation is invalid, it should be a no-op.
        :type followerId: int
        :type followeeId: int
        :rtype: void
        """
        try:
            followee = self.users[followeeId]
        except KeyError:
            self.createUser(followeeId)
            followee = self.users[followeeId]

        try:
            follower = self.users[followerId]
        except KeyError:
            self.createUser(followerId)
            follower = self.users[followerId]

        if followerId == followeeId:
            return

        if followerId in followee["followers"]:
            followee["followers"].remove(followerId)
            follower["following"].remove(followeeId)
            follower["feed"] = filter(lambda t: t["userId"] != followeeId, follower["feed"])



            # Your Twitter object will be instantiated and called as such:
            # obj = Twitter()
            # obj.postTweet(userId,tweetId)
            # param_2 = obj.getNewsFeed(userId)
            # obj.follow(followerId,followeeId)
            # obj.unfollow(followerId,followeeId)