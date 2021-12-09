class Main {
  public static void main(String[] args) {
    //  Create new tweets from archived collection
    Tweet post1 = new Tweet("SAVE OUR SECOND AMENDMENT. VOTE!", "5 Oct 2020");
    Tweet post2 = new Tweet("The Fake News has reached an all time high!", "29 Nov 2021");
    Tweet post3 = new Tweet("Thank you Kansas - I love you!", "6 Oct 2018");
    // New politician
    User republican = new User("Donald", "Trump");
    // Add posts
    republican.addTweet(post1);
    republican.addTweet(post2);
    republican.addTweet(post3);
    // Guess party based off biased words
    System.out.println(republican.guessParty());
  }
}