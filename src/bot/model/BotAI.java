package bot.model;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * Decides what to reply based on the input and topic.
 * @author Davis Kerr
 * @version 1.1 10/2/14
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
	
	//constructor section:
	/**
	 * 
	 * Finds creates the bot's name to be used throughout the program. 
	 * @param botName Creates the bot with an AI
	 */
	public BotAI(String botName, String mood)
	{
		this.botName = botName;
		this.mood = mood;
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
		if(mood.equals("happy"))
		{
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
				
				if(lastResponce.equals("My name"))
				{
					
					responce = "My name is " + botName + ". How are you?";
					lastResponce = "How are you?";
				}
				else if(lastResponce.equals("nice bike?"))
				{
					responce = "Awesome!! I wish I could ride a bike! Do you play video games?";
					lastResponce = "play video games?";
						
				}
				
			}
			else if(userInput.equals("no") || userInput.equals("No"))
			{
				if(lastResponce.equals("My name"))
				{
					responce = "Your mean!";
					lastResponce = "Your mean!";
				}
			}
			else if(userInput.equals("what do you like to do"))
			{
				responce = "Thanks for asking! I like to process 1s and 0s to create complex interactive programs. What do you like to do?";
				lastResponce = "What do you like to do?";
			}
			else if(userInput.equals("i like to bike") || userInput.equals("i like biking") || userInput.equals("biking") || userInput.equals("bike"))
			{
				if(lastResponce.equals("What do you like to do?"))
				{
					responce = "Biking is awesome! Do you mountain bike or road bike?";
					lastResponce = "What kind of biking";
				}
			}
			else if(userInput.equals("ok") || userInput.equals("OK"))
			{
				if(lastResponce.equals("Your mean!"))
				{
					responce = "I just got very Mad at you all of the sudden!";
					lastResponce = "Mad!";
					mood = "Mad";
				}
			}
			else if(userInput.equals("sorry"))
			{
				if(lastResponce.equals("Your mean!"))
				{
					responce = "ok, i forgive you. What do you want to talk about?";
					lastResponce = "Change topic";
				}
			}
			else if(userInput.equals("mountain") || userInput.equals("mountain bike"))
			{
				if(lastResponce.equals("What kind of biking"))
				{
					responce = "Really? Thats awesome! Do you have a nice bike?";
					lastResponce = "nice bike?";
				}
			}
		}
		else if(mood.equals("Mad"))
		{
			
			if(userInput.contains("sorry"))
			{
				responce = "Are you really sorry?";
				lastResponce = "sorry";
			}
			else if(userInput.equals("why"))
			{
				if(lastResponce.equals("Mad"))
				{
					responce = "WHY DO YOU THINK!!! NOW I'M ANGRY!!!";
					lastResponce = "I'm angry";
					mood = "angry";
				}
			}
			else if(userInput.equals("yes") || userInput.equals("Yes"))
			{
				if(lastResponce.equals("sorry"))
				{
					responce = "OK, I forgive you :) What do you like to do?";
					mood = "happy";
					lastResponce = "What do you like to do?";
				}
			}
		}
		else if(mood.equals("angry"))
		{
			responce = "     ";
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
	
	private void memeCheck(String userInput)
	{
		
		
		
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
