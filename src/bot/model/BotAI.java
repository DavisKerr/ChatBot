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
		topic = "introductions";
		updateChatCount();
	}
	
	/**
	 * The method that collects the input given in the ContinueConversation method in the BotView class. It then sets the responce based on the input. See the getResponce method. 
	 * @param userInput Uses the input provided in BotView.
	 */
	public void botReply(String userInput)
	{
		
		this.userInput = userInput;
		if(userInput.equals(""))
		{
			if(userInput.equals("what is your name"))
			{
				
				responce = "My name is " + botName + " Do you want to talk about stuff?";
				topic = "changeTopic";
			}
			else if(userInput.equals("what do you like to do"))
			{
				
				responce = "I'm a computer program... I dont like to do anything. What do you like to do?";
				topic = "Change topic";
				
			}
			else
			{
				
				
				
			}
			
		}
		else if(topic.equals("activities"))
		{
			
			if(userInput.equals("swimming"))
			{
				
				
				
			}
			
		}
		else if(userInput.equals("what do you like to do"))
		{
			responce = "I'm a computer program... I dont like to do anything. What do you like to do?";
			topic = "activities";
		}
		else
		{
			
			responce = "I wasn't programmed to know what " + userInput + " is.";
			
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
