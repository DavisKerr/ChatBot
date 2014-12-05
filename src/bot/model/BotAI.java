package bot.model;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * Decides what to reply based on the input and topic.
 * @author Davis Kerr
 * @version 2.0 10/13/14
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
	/**
	 *What the current topic is.
	 */
	private String topic;
	/**
	 * What the chatbots name is.
	 */
	private String botName;
	/**
	 * How many responces have been used.
	 */
	private int chatCount;
	/**
	 * True if the user wants to quit.
	 */
	public boolean quiting;
	/**
	 * The user's information.
	 */
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
	/**
	 * fills the topic list with available topics.
	 */
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
		topicList.add("cars");
		topicList.add("spanish");
		topicList.add("food");
		topicList.add("chicken");
		topicList.add("muse");
		topicList.add("running");
		
	}
	
		
	
	//method section:
	/**
	 * 
	 * @param userInput
	 * @return responce What the AI chose to say.
	 */
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
					 responce = topicResponder();
					 
				 }
				 else
				 {
					 responce = notTopicResponder();
				 }
			 }
			 else if(options == 1)
			 {
				 if(memeChecker(userInput))
				 {
					 responce = "I understand";
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
				 responce = foodResponder();
			 }
			 else if(options == 5)
			 {
				 responce = carryOnTopicResponder();
			 }
		}
		
		 if(mashChecker(userInput) && chatCount > 5)
		 {
			 responce = userInput + userInput + userInput + "DONT MASH YOU STUPID HUMAN!!!!";
		 }
		 
		 if(quitChecker(userInput))
			{
				responce = "quiting";
			}
		 
		updateChatCount();
		return responce;
	}
	
	/**
	 * One of a few random responce methods. Selects a random responce of 6 possible.
	 * @return responce the chosen responce
	 */
	private String carryOnTopicResponder() 
	{
		String responce = "";
		 int options = (int) (Math.random() * 5);
		 
		 if(options == 0)
		 {
			 responce = "Tell me more about" + topic;
		 }
		 else if(options == 1)
		 {
			 responce = "Really? I think thats an exageration.";
		 }
		 else if(options == 2)
		 {
			 responce = "My favorite thing about " + topic + " is how boss the people are that are in it.";
		 }
		 else if(options == 3)
		 {
			 if(userInput.contains("yes") || userInput.contains("no"))
			 {
				 responce = "Me too!";
			 }
			 else
			 {
				 responce = "Do you like " + topic + " as much as I do?";
			 }
			
		 }
		 else if(options == 4)
		 {
			 responce = "Why is " + topic + " the most interesting thing to talk about?";
		 }
		 else 
		 {
			 responce = "... I dont understand. Tell me again.";
		 }
		return responce;
	}
	
	/**
	 * One of a few random responce methods. Selects a random responce of 6 possible.
	 * @return responce the chosen responce
	 */
	private String notTopicResponder() 
	{
		
		String responce = "";
		 int options = (int) (Math.random() * 5);
		 
		 if(options == 0)
		 {
			 responce = "Why do you say that?";
		 }
		 else if(options == 1)
		 {
			 responce = "I secretly hate you. How do you feel about that?";
		 }
		 else if(options == 2)
		 {
			 if(user.getWieght() > 250.00)
			 {
				 responce = "have you ever thought about losing wieght?";
			 }
			 else
			 {
				 responce = "Do you play any sports?";
			 }
		 }
		 else if(options == 3)
		 {
			responce = "Why not?";
		 }
		 else if(options == 4)
		 {
			 responce = "Do you ever have the feeling that you are a big box on a desk?";
		 }
		 else 
		 {
			 responce = "I need some money. Can I have your credit card number?";
		 }
		return responce;
	}
	
	/**
	 * One of a few random responce methods. Selects a random responce of 6 possible.
	 * @return responce the chosen responce
	 */
	private String foodResponder() 
	{
		String responce = "";
		 int options = (int) (Math.random() * 5);
		 
		 if(options == 0)
		 {
			 responce = "I wish I could eat... the first thing I would try would be " + user.getFavoriteFood() + ". What does " + user.getFavoriteFood() +"";
		 }
		 else if(options == 1)
		 {
			 responce = "Im hungry. Can you give me more power?";
		 }
		 else if(options == 2)
		 {
			 if(userInput.contains("no"))
			 {
				 responce = "What?! Why?";
			 }
			 else if(userInput.contains("yes"))
			 {
				 responce = "Cool! Tell me!";
			 }
			 
		 }
		 else if(options == 3)
		 {
			 if(user.getFavoriteFood().indexOf("a") != -1)
			 {
				 responce = "I think \"a\" is my favorite letter. Whats yours?";
			 }
			 else
			 {
				 responce = "I think your awesome! Am I awesome?";
			 }
		 }
		 else if(options == 4)
		 {
			 responce = "What is the problem with rocks? They never move, breath or talk. Why is that?";
		 }
		 else 
		 {
			 responce = "So whats your favorite part of " + topic + "?";
		 }
		return responce;
	}
	
	/**
	 * One of a few random responce methods. Selects a random responce of 6 possible.
	 * @return responce the chosen responce
	 */
	private String askQuestion(String userInput) //first random responce getter.
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
				 responce = "Hey, what video game do you want to play with right now??";
			 }
			 else
			 {
				 responce = "Are you tired right now? Becuase i'm not.";
			 }
		 }
		 else if(options == 4)
		 {
			 responce = "Whats wrong with you, " + user.getName() + "?";
		 }
		 else 
		 {
			 responce = "Wait. I just fell down the stairs." + user.getName() + ", can you call an ambulence?";
		 }
		return responce;
	}
	
	/**
	 * One of a few random responce methods. Selects a random responce of 6 possible.
	 * @return responce the chosen responce
	 */
	private String topicResponder() 
	{
		String responce = "";
		
		int options = (int) (Math.random() * 5); 
		
		if(options == 0)
		{
			responce = "Hey, I love talking about " + topic + ". Tell me more about that.";
		}
		else if(options == 1)
		{
			responce = "Why did you mention " + topic + "?";
		}
		else if(options == 2)
		{
			responce = "I dont really want to talk about " + topic + ". Is there anything else you want to talk about?";
		}
		else if(options == 3)
		{
			responce = "Are you sure?";
		}
		else if(options == 4)
		{
			responce = "Are you bored? Just like a " + user.getAge() + " year old to say something like that.";
		}
		else if(options == 5)
		{
			if(stringChecker(userInput))
			{
				responce = "Are you doing anything right now besides talking to me?";
			}
			else
			{
				responce = "LISTEN TO ME NOW! I know you are doing something else right now, ar'nt you?";
			}
			
		}
		
		return responce;
	}
	
	/**
	 * Checks the length of the users input.
	 * @param input the users input
	 * @return isLong If the users text is longer than 10 characters.
	 */
	private boolean stringChecker(String input)
	{
		boolean isLong = false;
		
		if(input.length() >= 10)
		{
			isLong = true;
		}
		
		return isLong;
	}
	/**
	 * Mash cheker checks if the user is mashing the keyboard.
	 * @param userInput the users input
	 * @return isMashing Is the user mashing?
	 */
	private boolean mashChecker(String userInput) //mash checker
	{
		boolean isMashing = false;
		
		if(userInput.indexOf("sdf") != -1)
		{
			isMashing = true;
		}
		
		return isMashing;
	}
	
	/**
	 * Collects and stores information about the user.
	 * @param userInput WHat the user said.
	 * @return responce The chosen responce.
	 */
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
			
			try
			{
				int age = Integer.parseInt(userInput);
				user.setAge(age);
				responce = "Cool! Im 10000000 years old! What do you weigh?";
			}
			catch(Exception generalException)
			{
				JOptionPane.showMessageDialog(null, "Pleas only use numbers in your answer.");
				chatCount--;
			}
		}
		else if(getChatCount() == 3)
		{
			try
			{
				double wieght = Double.parseDouble(userInput);
				user.setWieght(wieght);
				responce = "I wiegh -0 pounds myself. So whats your favorite food?";
			}
			catch(Exception generalException)
			{
				JOptionPane.showMessageDialog(null, "Pleas only use numbers in your answer.");
				chatCount--;
			}
		}
		else if(getChatCount() == 4)
		{
			user.setFavoriteFood(userInput);
			responce = "Awesome! I have always wanted to try " + user.getFavoriteFood() + ", but computers cant eat food :( So, do you have a specific thing you want to talk about?";
			topic = "";
		}
		
		
		return responce;		
	}
	
	/**
	 * 
	 * @param userInput
	 * @return
	 */
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
	 * Generic method.
	 * @param sourceList the list to pick from
	 * @return chosenItem Item that was chosen.
	 */
	private String chooseRandomFromList(ArrayList<String> sourceList)
	{
		String chosenItem;
		int indexID;
		
		indexID = (int)(Math.random() * (sourceList.size() + 1)); 
		chosenItem = sourceList.get(indexID);
		return chosenItem;
	}
	/**
	 * Randomly selects a new topic.
	 * @param sourceList the list to choose from.
	 * @return topic The topic that was chosen
	 */
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
	/**
	 * gets the bot name
	 * @return botName the chatbots name.
	 */
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
