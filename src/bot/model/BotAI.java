package bot.model;

import java.util.Random;

import javax.swing.JOptionPane;

/**
 * Decides what to reply based on the input and topic.
 * @author Davis Kerr
 *@version 1
 */
public class BotAI
{
	
	//variable declaration:
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
	
	//constructor section:
	/**
	 * 
	 * Finds creates the bot's name to be used throughout the program. 
	 * @param botName Creates the bot with an AI
	 */
	public BotAI(String botName)
	{
		this.botName = botName;
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
	 * The method that collects the input given in the ContinueConversation method in the BotView class. It then sets the responce based on the input. See the getResponce method. 
	 * @param userInput Uses the input provided in BotView.
	 */
	public void BotReply(String userInput)
	{
		
		this.userInput = userInput;
		if(userInput.contains("what is your name") || userInput.equals("whats your name"))
		{
			
			responce = "My name is " + botName + ". How are you?";
			lastResponce = "How are you?";
			
		}
		else if(userInput.equals("good") || userInput.equals("i am good"))
		{
			
			if(lastResponce.equals("How are you?"))
			{
				
				responce = "Thats Great! What do you like to do?";
				lastResponce = "What do you like to do?";
				
			}
			
		}
		else if(userInput.contains("hi") || userInput.contains("hello")) 
		{
			
			if(lastResponce.equals("introductions"))
			{
				
				responce = "HI! Are you going to ask me my name?";
				lastResponce = "My name";
				
			}
			
			
		}
		else if(userInput.contains("yes") || userInput.equals("Yes"))
		{
			
			
			
		}
		
		updateChatCount();
		
	}
	
	
	/**
	 * updates the chat count
	 * 
	 */
	private void updateChatCount()
	{
		
		chatCount++;
		
	}
	
	
		
	
	//getter section:
	/**
	 * returns responce to the BotAppController
	 * @return responce
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
}
