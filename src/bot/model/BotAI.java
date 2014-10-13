package bot.model;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * Decides what to reply based on the input and topic.
 * @author Davis Kerr
 * @version 1.3 10/9/14
 */
public class BotAI
{
	
	// variable declaration:
	private ArrayList<String> memeList; 
	private String userInput;
	private String responce;
	private String topic;
	private String botName;
	private String botFavColor;
	private String botFavFood;
	private int chatCount;
	private Random rand;
	private int botData;
	private String userName;
	private String lastResponce;
	private String mood;
	public boolean quiting;
	
	//constructor section:
	/**
	 * 
	 * Finds creates the bot's name to be used throughout the program. 
	 * @param botName Creates the bot with an AI
	 */
	public BotAI(String botName, String mood)
	{
		memeList = new ArrayList<String>();
		this.botName = botName;
		this.mood = mood;
		chatCount = 0;
		fillMemeList();
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
		
		if(!userInput.equalsIgnoreCase("quit") || userInput == null)
		{
			quiting = false;
		}
		else
		{
			quiting = true;
		}
		
		int randomPosition = (int) (Math.random() * 3);
		
		if(randomPosition == 0)
		{
			if(!stringChecker(userInput))
			{
				responce = "Too short of an answer!";
			}
			else
			{
				responce = "Too long of an answer...";
			}
		}
		else if(randomPosition == 1)
		{
			if(!contentChecker(userInput))
			{
				responce = "You didn't mention destiny :(";
			}
			else
			{
				responce = "I LOVE DESTINY!!!";
			}
		}
		else
		{
			if(memeChecker(userInput))
			{
				responce = "Wow, " + userInput + " is a meme :D";
			}
			else
			{
				responce = "That is not a meme...";
			}
		}
		
		
		updateChatCount();
		return responce;
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
	private boolean contentChecker(String userInput)
	{
		boolean contentIsThere;
		
		if(userInput.contains("destiny"))
		{
			contentIsThere = true;
		}
		else
		{
			contentIsThere = false;
		}
		return contentIsThere;
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
	 * tells the program to quit.
	 * @return the value of quiting
	 */
	public boolean runQuitSequence()
	{
		
		return quiting;
		
	}
	

	
		
	
	
}
