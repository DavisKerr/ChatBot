package bot.model;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * Decides what to reply based on the input and topic.
 * @author Davis Kerr
 * @version 1.5 10/13/14
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
	
	//constructor section:
	/**
	 * 
	 * Finds creates the bot's name to be used throughout the program. 
	 * @param botName Creates the bot with an AI
	 */
	public BotAI(String botName, String mood, String topic)
	{
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
		
	}
	
	private void fillTopicList()
	{
		topicList.add("destiny");
		topicList.add("biking");
		topicList.add("sad");
		topicList.add("lotr");
		topicList.add("none");
		
	}
	
	//getter section:
		/**
		 * returns response to the BotAppController
		 * @return response
		 */
		public String getResponce()
		{
			
			return responce;
			
		}
		/**
		 * returns the botName to the BotAppController
		 * @return botName
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
	
	//method section:
	/**
	 *  The method that takes the name given by the BeginConversation method in the BotView class.
	 * @param userName Collects the userName to be used throughout the method/class
	 */
	public void BotFirstReply(String userName)
	{
		this.userName = userName;
		responce = "Well, Hello " + userName;
		lastResponce = "introductions";
		updateChatCount();
	}
	
	/**
	 * The method that collects the input given in the ContinueConversation method in the BotView class. It then sets the responce based on the input. 
	 * @param userInput Uses the input provided in BotView.
	 */
	public String BotReply(String userInput)
	{
		this.userInput = userInput;
		userInputList.add(userInput);
		if(!this.userInput.equalsIgnoreCase("quit") || userInput == null)
		{
			quiting = false;
		}
		else
		{
			quiting = true;
		}
		
		if(memeChecker(userInput))
		{
				
			if(chatCount == 0)
			{
				responce = "Hi! Whats your name";
			}
			else if(chatCount == 1)
			{
				
			}
			else if(chatCount == 2)
			{
				
			}
			else if(chatCount == 3)
			{
				
			}
			else if(chatCount == 4)
			{
				
			}
			else if(chatCount == 5)
			{
				
			}
			else
			{
				if(topicCounter == 5)
				{
					responce = changeTopic(topicList);
				}
				else
				{
					responce = inputChecker(userInput);
				}
			}
		}
		else // This happens when the user entered input that is not in the memeList.
		{
			responce = "I dont understand what you said. Try getting rid of punctuation or use simpler words.";
		}
		//int randomPosition = (int) (Math.random() * 6);
		
		//if(randomPosition == 0)
		//{
			//if(!stringChecker(userInput))
			//{
				//responce = "Too short of an answer!";
			//}
			//else
			//{
				//responce = "Too long of an answer...";
			//}
		//}
		//else if(randomPosition == 1)
		//{
			//if(!contentChecker(userInput))
			//{
			//	responce = "You didn't mention destiny :(";
			//}
			//else
			//{
			//	responce = "I LOVE DESTINY!!!";
			//}
		//}
		//else
		//{
			//if(memeChecker(userInput))
			//{
			//	responce = "Wow, " + userInput + " is a meme :D";
			//}
			//else
			//{
			//	responce = "That is not a meme...";
			//}
		//}
		
		
		updateChatCount();
		return responce;
	}
	
	private boolean usrInputChecker(String userInput)
	{
		boolean matchesInput = false;
		
		for(int loopCount = 0; loopCount < userInputList.size(); loopCount++)
		{
			if(userInput.equalsIgnoreCase(userInputList.get(loopCount)))
			{
				userInputList.remove(loopCount);
				// the number of items in a list shift down, so I must manually subtract one from the loopCount so it still checks all of the items.
				loopCount --; //manually sets back the loop count
			}
		}
		return matchesInput;
	}
	
	/**
	 * Checks the length of the string.
	 * @param userInput What the user typed in.
	 * @return isLong returns true or false based on the length.
	 */
	private boolean stringChecker(String userInput)
	{
		boolean isLong;
		
		if(userInput.length() <= 10)
		{
			isLong = false;
		}
		else
		{
			isLong = true;
		}
		return isLong;
	}	
	
	/**
	 * Checks to see if the user talked about specific topics
	 * @param userInput What the user entered
	 * @return contentIsThere true or false depending on the content
	 */
	private String contentChecker(String userInput)
	{
		String content = "none";
		
		if(userInput.contains("destiny"))
		{
			content = "destiny";
		}
		else if(userInput.contains("lord of the rings"))
		{
			content = "lotr";
		}
		return content;
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
	
	private String inputChecker( String userInput)
	{
		String responder;
		responder = "none";
		//checks if the topic is introductions.
		if(topic.equals("intro"))
		{
			if(userInput.contains("hi") || userInput.equals("hello") || userInput.equals("sup") || userInput.equals("whats up") || userInput.equals("hey") || userInput.equals("hi") || userInput.equals("hello there"))
			{
				responder = "Hi. are you going to ask my name?";
			}
			else if(userInput.equals("what is your name") || userInput.equals("whats your name") || userInput.equals("yes") || userInput.equals("ok") || userInput.equals("sure"))
			{
				responder = "My name is " + botName + " what do you want to talk about?";
				this.topic = "none";
				topicCounter = 0;
			}
			else if(userInput.equals("no") || userInput.contains("I hate you"))
			{
				responder = "oh... ok :( im sad now...";
				this.topic = "sad";
				topicCounter = 0;
			}
			else if(userInput.equals("lets talk about something else") || userInput.equals("lets change the topic") || userInput.equals("change the topic"))
			{
				responce = "OK. What do you want to talk about?";
				this.topic = "none";
				topicCounter = 0;
			}
			else //This happens when the user types in an irrelevant response that is not caught by the memeList.
			{
				responder = "That was a random and irrelevent statement. Why dont you ask me my name right now?";
			}
		}	
		// find a new topic
		if(topic.equals("none"))
		{
			if(userInput.equals("destiny"))
			{
				responder = "Cool! Destiny is awesome! What class do you play as?";
				topic = "destiny";
				topicCounter = 0;
			}
			else if(userInput.equals("biking") || userInput.contains("bike") || userInput.equals("i like to bike"))
			{
				responder = "Biking is awesome! Do you mountain bike or road bike? ";
				this.topic = "biking";
				topicCounter = 0;
			}
			else if(userInput.equals("lord of the rings") || userInput.equals("lotr"))
			{
				responder = "I live for lord of the rings!!! Who is your favorite character?";
				this.topic = "lotr";
				topicCounter = 0;
				
			}else if(userInput.contains("jokes") || userInput.contains("tell me a joke") || userInput.equals("entertain me") || userInput.contains("funny"))
			{
				topicCounter = 0;
			}
			else
			{
				responce = "I dont know anything about " + userInput +". What else do you want to talk about?";
			}
		}
		//talks about destiny
		if(this.topic.equals("destiny"))
		{
			if(userInput.equals("warlock"))
			{
				
				topicCounter++;
			}
			else if(userInput.equals("lets talk about something else") || userInput.equals("lets change the topic") || userInput.equals("change the topic"))
			{
				responce = "OK. what do you want to talk about?";
				this.topic = "none";
				topicCounter = 0;
			}
		}
		
		if(this.topic.equals("lotr"))
		{
			if(userInput.equals("gandalf"))
			{
				topicCounter++;
			}
			else if(userInput.equals("lets talk about something else") || userInput.equals("lets change the topic") || userInput.equals("change the topic"))
			{
				responce = "OK. What do you want to talk about?";
				this.topic = "none";
				topicCounter = 0;
			}
		}
		
		if(this.topic.equals("biking"))
		{
			if(userInput.equals("mountain biking"))
			{
				topicCounter++;
			}
			else if(userInput.equals("lets talk about something else") || userInput.equals("lets change the topic") || userInput.equals("change the topic"))
			{
				responce = "OK. What do you want to talk about?";
				this.topic = "none";
				topicCounter = 0;
			}
		}
		
		
		
		
		return responder;
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
	

	
		
	
	
}
