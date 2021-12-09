import java.util.ArrayList;

public class User{
    // Tweeter user obj that has tweets
  private String first_name;
  private String last_name;
  private int total_posts;
  private ArrayList<Tweet> tweets = new ArrayList<>();
  private double affiliation;
  
  public User(String x, String y)
  { 
    //   Create a new user with no affiliation for record
    first_name = x;
    last_name=y;
    total_posts=0;
    affiliation = 0;
  }
//   Add tweet to user's tweets and increase the post
  public void addTweet(Tweet tweet)
  {
    tweets.add(tweet);
    total_posts+=1;
    
  }
//   Getter for raw affiliation value
  public double getAffiliation(){
      return affiliation;
  }
//   Loop through all users tweets and calc avr affiliation
  public String guessParty()
  {  
    double value=0;
    double count=0;
     for (Tweet element : tweets) {
        value += element.totalAffiliation();
        count++;
        
    }
    if (count!=0)
    affiliation += value/count;
    // Return party affilation prediction 
    String base = "Based off of " +total_posts+ " tweets from " +first_name + " "+ last_name+ ". "+first_name+" is most likely ";
    if (affiliation>0)
    return base+"Republican.";
    else if(affiliation <0)
    return base+"a Democrat.";
    else
    return base+"unaffiliated.";

  }
}

