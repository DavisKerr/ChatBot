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
	/**
	 * What the current topic is.
	 */
	private String topic;
	/**
	 * The name of the chatBot.
	 */
	private String botName;
	/**
	 * The Chatbot's favorite color.
	 */
	@SuppressWarnings("unused")
	private String botFavColor;
	/**
	 * How many messages the user has sent.
	 */
	private int chatCount;
	/**
	 * The name of the user.
	 */
	private String userName;
	/**
	 * what the last responce was.
	 */
	private String lastResponce;
	/**
	 * What the chatbot's mood is.
	 */
	private String mood;
	/**
	 * Tells the computer if the user wants to quit.
	 */
	public boolean quiting;
	/**
	 * How long a topic has been discussed.
	 */
	private int topicCounter;
	/**
	 * to be added.
	 */
	private String content;
	
	private ChatbotUser user;
	
	private String lastQuestion;
	
	//constructor section:
	/**
	 * 
	 * Finds creates the bot's name to be used throughout the program. 
	 * @param botName Creates the bot with an AI
	 */
	public BotAI(String botName, String mood, String topic, ChatbotUser user)
	{
		this.user = user;
		this.topic = topic;
		memeList = new ArrayList<String>();
		topicList = new ArrayList<String>();
		userInputList = new ArrayList<String>();
		this.botName = botName;
		this.mood = mood;
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
		topicList.add("d&d");
		topicList.add("d and d");
		
	}
	
		
	
	//method section:
	
	public String processText(String userInput)
	{
		responce = "";
		
		 int options = (int) Math.random() * 5;
		
		return responce;
	}
	
	/**
	 * The method that collects the input given in the ContinueConversation method in the BotView class. It then sets the responce based on the input. 
	 * @param userInput Uses the input provided in BotView.
	 */
	public String BotReply(String userInput)
	{
		this.userInput = userInput;
		userInputList.add(userInput);
		
		if(chatCount < 5)
		{
			topic = "introductions";
			responce = introductions(userInput);
		}
		if (topic.equals("") && getChatCount() >= 5)
		{
			
			topic = checkTopic(userInput);
			
			if(topic.equalsIgnoreCase(""))
			{
				responce = "I dont know anything about that. Can you choose anouther topic?";
			}
			else
			{
				
				responce = topicMentioned(topic);
				topicCounter = 0;
			}
		
			
		}
		else if(!topic.equals("") && getChatCount() >= 5)
		{
			if(!lastQuestion.equals("Change topic"))
			{
				responce = topicResponce(userInput);
				topicCounter = topicCounter++;
			}
			else
			{
				responce = "I have talked about that too much. choose a different topic.";
				topic = "";
			}
			
		}
		
		updateChatCount();
		return responce;
	}
	
	private String topicResponce(String userInput) 
	{
		String chosenResponce = "";
		
		//if the topic is destiny
		if(topic.equals("destiny"))
		{
			if(lastQuestion.equals("class"))
			{
				if(userInput.contains("warlock"))
				{
					chosenResponce = "COOL! thats my favorite class! what is your favorite planet?";
					lastQuestion = "planet";
				}
				else if(userInput.contains("titan"))
				{
					chosenResponce = "Nice. my brother uses that class! Whats your favorite planet?";
					lastQuestion = "planet";
				}
				else if(userInput.contains("hunter"))
				{
					chosenResponce = "ok. I have never used that class. Whats your favorite panet?";
					lastQuestion = "planet";
				}
			}
			if(lastQuestion.equals("planet"))
			{
				if(userInput.contains("mars"))
				{
					chosenResponce = "Mars is fun, but hard. what level are you?";
					lastQuestion = "level";
				}
				if(userInput.contains("venus"))
				{
					chosenResponce = "Venus is too short. What level are you?";
					lastQuestion = "level";
				}
				if(userInput.contains("earth"))
				{
					chosenResponce = "Earth is to easy XD. What level are you?";
					lastQuestion = "level";
				}
				if(userInput.contains("moon"))
				{
					chosenResponce = "The moon is my favorite! What level are you?";
					lastQuestion = "level";
				}
			}
			else if(lastQuestion.equals("level"))
			{
				int level = 0; 
				try
				{
					level = Integer.parseInt(userInput);
				}
				catch(Exception generalException)
				{
					JOptionPane.showMessageDialog(null, "Please only answer in numbers.");
				}
				if(level <= 0)
				{
					responce = "Liar. You must not play destiny!";
					lastQuestion = "Change topic";
				}
				else if(level <= 10)
				{
					responce = "Thats not very high...";
					lastQuestion = "Change topic";
				}
				else if(level <= 20)
				{
					responce = "Your almost to level 20! Keep pushing!";
					lastQuestion = "Change topic";
				}
				else if(level <= 30)
				{
					responce = "your super good!";
					lastQuestion = "Change topic";
				}
				else
				{
					responce = "Liar. thats not even possible!";
					lastQuestion = "Change topic";
				}
			}
		}
		
		return chosenResponce;
	}
	private String topicMentioned(String topic) 
	{
		String chosenResponce = "";
		
		if(topic.equals("destiny"))
		{
			chosenResponce = "I love destiny! what class are you?";
			lastQuestion = "class";
		}
		else if(topic.equals("biking"))
		{
			chosenResponce = "I love biking! do you road bike or mountain bike?";
			lastQuestion = "bikeType";
		}
		else if(topic.equals("computers"))
		{
			chosenResponce = "Really? are you mac or pc?";
			lastQuestion = "mac vs. pc";
		}
		else if(topic.equals("lotr") || topic.equals("lord of the rings"))
		{
			chosenResponce = "LOTR IS MY FAVORITE! Who is your favorite member of the felloship?";
			lastQuestion = "fellowship";
		}
		else if(topic.equals("dungeons and dragons") || topic.equals("d&d") || topic.equals("d and d"))
		{
			chosenResponce = "I love d&d! What is your prefered race?";
			lastQuestion = "d&d race";
		}
		
		return chosenResponce;
	}
	private String introductions(String userInput)
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
	
	private String checkTopic(String userInput)
	{
		String chosenTopic = "";
		boolean isATopic = false;
		for(String currentMeme : topicList)
		{
			
			if(userInput.equalsIgnoreCase(currentMeme) || userInput.contains(currentMeme))
			{
				isATopic = true;
				chosenTopic = currentMeme;
			}
			
		}
		
		return chosenTopic;
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
	private boolean memeChecker(String input)
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
	 * @return the value of quiting
	 */
	public boolean runQuitSequence()
	{
		
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
