package bot.model;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * Decides what to reply based on the input and topic.
 * @author Davis Kerr
 * @version 1.6 10/13/14
 */
public class BotAI
{
	
	// variable declaration:
	/**
	 * An ArrayList that holds all of the available topics.
	 */
	private ArrayList<String> topicList; // <type> is a typeCast.
	/**
	 * An ArrayList that holds all available inputs.
	 */
	private ArrayList<String> memeList; 
	/**
	 * An ArrayList that holds all the user inputs.
	 */
	private ArrayList<String> userInputList;
	/**
	 * What the user typed in.
	 */
	private String userInput;
	/**
	 * What the computer types in.
	 */
	private String responce;
	private String topic;
	private String botName;
	private int chatCount;
	public boolean quiting;
	private ChatbotUser user;
	
	
	//constructor section:
	/**
	 * 
	 * Finds creates the bot's name to be used throughout the program. 
	 * @param botName Creates the bot with an AI
	 */
	public BotAI(String botName, ChatbotUser user)
	{
		this.user = user;
		this.topic = topic;
		memeList = new ArrayList<String>();
		topicList = new ArrayList<String>();
		userInputList = new ArrayList<String>();
		this.botName = botName;
		chatCount = 0;
		fillMemeList();
		fillTopicList();
	}
	/**
	 * fills the list of available input options
	 */
	private void fillMemeList()
	{
		
		memeList.add("yes");
		memeList.add("destiny");
		memeList.add("ok");
		memeList.add("bike");
		memeList.add("good");
		memeList.add("hi");
		memeList.add("hello");
		memeList.add("what is your name");
		memeList.add("whats your name");
		memeList.add("quit");
		memeList.add("biking");
		memeList.add("good");
		memeList.add("i am good");
		memeList.add("no");
		memeList.add("i like to bike");
		memeList.add("biking");
		memeList.add("mountain");
		memeList.add("mountain bike");
		memeList.add("bye");
		memeList.add("destiny");
		memeList.add("lord of the rings");
		memeList.add("lotr");
		memeList.add("jokes");
		memeList.add("change topic");
		memeList.add("lets change the topic");
		memeList.add("lets talk about something else");
		memeList.add("funny");
		memeList.add("tell me a joke");
		memeList.add("entertain me");
		memeList.add("nope");
		memeList.add("my name is");
		memeList.add("you are a robot");
		memeList.add("your dumb");
		memeList.add("i hate you");
		memeList.add("stop");
		memeList.add("i want to ask a question");
		memeList.add("who made you");
		memeList.add("aragorn");
		memeList.add("frodo");
		memeList.add("sam");
		memeList.add("sauron");
		memeList.add("gimli");
		memeList.add("legolas");
		memeList.add("gandalf");
		memeList.add("nothing");
		memeList.add("bananas");
		memeList.add("other stuff");
		memeList.add("other inputs");
		memeList.add("ug");
		memeList.add("lugage");
		memeList.add("Davis");
		
	}
	
	private void fillTopicList()
	{
		topicList.add("destiny");
		topicList.add("biking");
		topicList.add("computers");
		topicList.add("lotr");
		topicList.add("lord of the rings");
		topicList.add("dungeons and dragons");
		topicList.add("trains");
		topicList.add("Pie");
		topicList.add("Cheese");
		topicList.add("Halo 4");
		topicList.add("Markers");
		topicList.add("Planes");
		topicList.add("ninjas");
		topicList.add("bananas");
		topicList.add("fire");
		topicList.add("space");
		topicList.add("dragons");
		topicList.add("moon");
		topicList.add("pizza");
		topicList.add("candy");
		topicList.add("christmas");
		
	}
	
		
	
	//method section:
	
	public String processText(String userInput)
	{
		responce = "Why?";
		
		if(chatCount < 5)
		{
			topic = "introductions";
			responce = introductions(userInput);
		}
		else
		{
			 int options = (int) (Math.random() * 5);
			 
			 if(options == 0)
			 {
				 if(checkTopic(userInput))
				 {
					 responce = "Cool! I like talking about " + topic + "! Whats your favorite part of " + topic + "?";
					 
				 }
				 else
				 {
					 responce = "I dont really want to talk about that. What do you want to talk about?";
				 }
			 }
			 else if(options == 1)
			 {
				 if(memeChecker(userInput))
				 {
					 responce = "Thats interesting. Are you sure?";
				 }
				 else
				 {
					 responce = "Wow! I never thought you would say that! Do you have anything else to add?";
				 }
			 }
			 else if(options == 2)
			 {
				 responce = askQuestion(userInput);
			 }
			 else if(options == 3)
			 {
				 responce = changeTopic(topicList);
			 }
			 else if(options == 4)
			 {
				 responce = "I think I will make you " + user.getFavoriteFood() + " to eat.";
			 }
			 else if(options == 5)
			 {
				 responce = "I think you are being mean... SAY SORRY!!!";
			 }
		}
		
		
		 if(quitChecker(userInput))
			{
				responce = "quiting";
			}
		 
		updateChatCount();
		return responce;
	}
	
	private String askQuestion(String userInput) 
	{
		String responce = "";
		
		 int options = (int) (Math.random() * 5);
		 if(options == 0)
		 {
			 responce = "I just fell asleep while you were talking. Can you say that again?";
		 }
		 else if(options == 1)
		 {
			 responce = "Im bored. Say something entertaining?";
		 }
		 else if(options == 2)
		 {
			 responce = "Interesting. Tell me more.";
		 }
		 else if(options == 3)
		 {
			 if(user.getAge() <= 15)
			 {
				 responce = "Hey, your really young. Why dont you go play outside?";
			 }
			 else
			 {
				 responce = "Your old enough to understand that Im a robot, not a person, right?";
			 }
		 }
		 else if(options == 4)
		 {
			 responce = "Whats wrong with you, " + user.getName();
		 }
		 else 
		 {
			 responce = "Wait. I just fell down the stairs." + user.getName() + ", can you call an ambulence?";
		 }
		return responce;
	}
	private boolean mashChecker(String userInput)
	{
		boolean isMashing = false;
		
		if(userInput.indexOf("sdf") == -1)
		{
			isMashing = true;
		}
		
		return isMashing;
	}
	
	private String introductions(String userInput) //Introductions
	{
		responce = "";
		
		if(getChatCount() == 0)
		{
			responce = "Hello, my name is ChatBot. Whats your name?";
		}
		else if(getChatCount() == 1)
		{
			user.setName(userInput);
			responce = "Nice name, " + user.getName() + ". How old are you?";
		}
		else if(getChatCount() == 2)
		{
			int age = Integer.parseInt(userInput);
			user.setAge(age);
			responce = "Cool! Im 10000000 years old! What do you weigh?";
		}
		else if(getChatCount() == 3)
		{
			double wieght = Double.parseDouble(userInput);
			user.setWieght(wieght);
			responce = "I wiegh -0 pounds myself. So whats your favorite food?";
		}
		else if(getChatCount() == 4)
		{
			user.setFavoriteFood(userInput);
			responce = "Awesome! I have always wanted to try " + user.getFavoriteFood() + ", but computers cant eat food :( So, do you have a specific thing you want to talk about?";
			topic = "";
		}
		
		
		return responce;		
	}
	
	private boolean checkTopic(String userInput) //content Checker
	{
		boolean isATopic = false;
		for(String currentMeme : topicList)
		{
			
			if(userInput.equalsIgnoreCase(currentMeme) || userInput.contains(currentMeme))
			{
				isATopic = true;
				topic = currentMeme;
			}
			
		}
		
		return isATopic;
	}
	
	/**
	 * updates the chat count
	 * 
	 */
	private void updateChatCount()
	{
		
		chatCount++;
		
	}
	/**
	 * Checks if the users input is in the list.
	 * @param input what the user said
	 * @return isAMeme can be true or false
	 */
	private boolean memeChecker(String input)//memeChecker
	{
		boolean isAMeme = false;
		
		for(String currentMeme : memeList)
		{
			if(input.equalsIgnoreCase(currentMeme))
			{
				isAMeme = true;
			}
		}
		
		for(int loopCounter = 0; loopCounter < memeList.size(); loopCounter++)
		{
			if(input.equalsIgnoreCase(memeList.get(loopCounter)))
			{
				isAMeme = true;
			}
		}
		
		return isAMeme;
	}
	
	/**
	 * picks a random item from a list.
	 * @param sourceList the list to pick from
	 * @return
	 */
	private String chooseRandomFromList(ArrayList<String> sourceList)
	{
		String chosenItem;
		int indexID;
		
		indexID = (int)(Math.random() * (sourceList.size() + 1)); 
		chosenItem = sourceList.get(indexID);
		return chosenItem;
	}
	
	private String changeTopic(ArrayList<String> sourceList)
	{
		topic = "none";
		String chosenResponce = "none";
		
		topic = chooseRandomFromList(sourceList);
		
		chosenResponce = "I want to talk about " + topic + " now.";
		
		return chosenResponce;
	}
	
	/**
	 * tells the program to quit.
	 * @param userInput 
	 * @return the value of quiting
	 */
	public boolean quitChecker(String userInput) //quit checker
	{
		quiting = false;
		
		if(userInput.equals("quit") || userInput.equals("quiting") || userInput.equals("i want to quit")) 
		{
			quiting = true;
		}
		
		return quiting;
	}
	
	//getters
	public String getBotName()
	{
		
		return botName;
		
	}
	/**
	 * returns the chatCount to the BotAppController
	 * @return chatCount
	 */
	public int getChatCount()
	{
		return chatCount;
	}
	
	
}
