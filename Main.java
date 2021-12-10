import java.util.Scanner;

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
    System.out.println(republican);
    
    Scanner scan = new Scanner(System.in);
    System.out.println("\n\n#####  Create a profile  #####");
    System.out.println("Enter first name");
    String fname = scan.nextLine();
    System.out.println("Enter last name");
    String lname = scan.nextLine();
    User user = new User(fname, lname);
    String t_content,t_date, to_continue;
    Tweet user_tweet;
    while (true)
    {
        System.out.println("Add tweet (Y/N)");
        to_continue = scan.nextLine().toLowerCase();
        if ( !to_continue.equals("n"))
        {
            System.out.println("Tweet content:");
            t_content = scan.nextLine();
            System.out.println("Tweet date:");
            t_date = scan.nextLine();
            user_tweet = new Tweet(t_content,t_date);
            user.addTweet(user_tweet);
            System.out.println(user_tweet);
            
            }
        else
        {
            break;
        }
        
    }
    System.out.println(user);


  }
}