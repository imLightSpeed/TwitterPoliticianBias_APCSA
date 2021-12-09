import java.util.Scanner;
import java.io.File;
import java.util.HashMap;


public class Tweet
{
    // Holds data for a tweet and calculates the biased
  private String content; 
  private String date; 
  private static HashMap<String, Double> affiliation = new HashMap<String, Double>();
  
//   load csv file of biased words
  static{
    try {
      Scanner input = new Scanner(new File("bias.csv"));
      while(input.hasNextLine()){
        String[] temp = input.nextLine().split(",");
        affiliation.put(temp[0],Double.parseDouble(temp[2]));
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing bias.csv");
    }
  }
  public Tweet(String y, String z)
  {
    content = y;
    date = z;
    
  }
  public String getContent()
  {
    return content; 
  }
  public String getDate()
  {
    return date;  
  }
//   View the tweet
  public String toString()
  {
    return "Date: " + date + "\n Content: " + content;
  }
    // lookup word in csv file
  public static double getAffiliation(String word)
  {
    try
    {
      return affiliation.get(word.toLowerCase());
    }
    catch(Exception e)
    {
      return 0;
    }
  }
//   remove punctuation
  public static String removePunctuation( String word )
  {
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(0)))
    {
      word = word.substring(1);
    }
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length()-1)))
    {
      word = word.substring(0, word.length()-1);
    }
    
    return word;
  }
//   Average bias in words found in the tweet
  public double totalAffiliation()
  {
      double total = 0;
      int count = 0;
      String word = "";
      String tweet_content = content;
    //   Loop through each word
      for(int i = 0; i < tweet_content.length();i++)
      {
         if(tweet_content.substring(i, i + 1).equals(" ") || i + 1 == tweet_content.length()) 
         {
            total += getAffiliation(removePunctuation(word));
            count++;
            word = "";
         }
         else
         {
            word += tweet_content.substring(i, i + 1);
         }
           
      }
    //   Average the collection and avoid div by zero
      if(count!=0)
      return total/count;
      else
      return 0;
  }
}
