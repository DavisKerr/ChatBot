package bot.model;

import java.util.Random;

import javax.swing.JOptionPane;


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
	
	//constructor section:
	public BotAI()
	{
		chatCount = 0;
		rand = new Random();
	}
	
	//method section:
	public void BotFirstReply(String name)
	{
		
		responce = "Well, Hello " + name;
		topic = "introductions";
		updateChatCount();
	}
	
	public void botReply(String userInput)
	{
		
		this.userInput = userInput;
		if(topic.equals("introductions"))
		{
			if(userInput.equals("what is your name"))
			{
				
				responce = "My name is chatBot. Do you want to talk about stuff?";
				
			}
			else if(userInput.equals("what do you like to do"))
			{
				
				responce = "I'm a computer program... I dont like to do anything. What do you like to do?";
				topic = "activities";
				
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
	
	private void decideBotData()
	{
		
		botData = rand.nextInt(5) + 1;
		
		if(botData == 1)
		{
			botName = "Steve";
		}
		else if(botData == 2)
		{
			botName = "ChatBot2000";
		}
		else if(botData == 3)
		{
			botName = "Thor";
		}
		else if(botData == 4)
		{
			botName = "Rex";
		}
		else
		{
			botName = "Pig of doom";
		}
		
		botData = rand.nextInt(5) + 1;
		
		if(botData == 1)
		{
			botFavColor = "Red";
		}
		else if(botData == 2)
		{
			botFavColor = "Blue";
		}
		else if(botData == 3)
		{
			botFavColor = "Orange";
		}
		else if(botData == 4)
		{
			botFavColor = "Green";
		}
		else
		{
			botFavColor = "Puce";
		}
		
		botData = rand.nextInt(5) + 1;
		
		if(botData == 1)
		{
			botFavFood = "Pizza";
		}
		else if(botData == 2)
		{
			botFavFood = "Apples";
		}
		else if(botData == 3)
		{
			botFavFood = "Pasta";
		}
		else if(botData == 4)
		{
			botFavFood = "Chinese food";
		}
		else
		{
			botFavFood = "Dog meat";
		}
		
	}
	
	private void updateChatCount()
	{
		
		chatCount++;
		
	}
	
	
		
	
	//getter section:
	
	public String getResponce()
	{
		
		return responce;
		
	}
	
	public String getBotName()
	{
		
		return botName;
		
	}
}
