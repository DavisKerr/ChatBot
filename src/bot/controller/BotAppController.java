package bot.controller;


import javax.swing.JOptionPane;

import bot.model.BotAI;
import bot.view.BotView;

/**
 * Runs the project. Gathers data from the BotAI and the BotView.
 * @author Davis Kerr
 * @version 1.2 10/2/14
 */

public class BotAppController
{

	// variable declaration section:
	private boolean isRunning;
	private BotView appView;
	private String input;
	private BotAI appAI;
	private String responce;
	private String name;
	private String closeMessage;
	
	// constructor section:
	public BotAppController()
	{
		
		appView = new BotView();
		appAI = new BotAI("ChatBot", "happy");
	}
	
	// method section:
	public void start()
	{
		isRunning = true;
		
		while(input != "quit")
		{
			appView.beginConversation();
			name = appView.getName();
			appAI.BotFirstReply(name);
			responce = appAI.getResponce();
			while(isRunning == true)
			{
				
				appView.continueConversation(responce); 
				input = appView.getInput();
				
				appAI.BotReply(input);
				responce = appAI.getResponce();
				
			}
		}
		quit();
		
	}
	
	
	private void quit()
	{
		closeMessage = "DON'T KILL ME!!!";
		appView.showMessage(closeMessage);
		System.exit(0);
		
	}

	
}
