package bot.controller;


import javax.swing.JOptionPane;

import bot.model.BotAI;
import bot.model.ChatbotUser;
import bot.view.BotView;
import bot.view.ChatbotFrame;

/**
 * Runs the project. Gathers data from the BotAI and the BotView.
 * @author Davis Kerr
 * @version 1.3 10/2/14
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
	private ChatbotFrame appFrame;
	private ChatbotUser theUser;
	
	// constructor section:
	/**
	 * constructs the three other classes.
	 */
	public BotAppController()
	{
		theUser = new ChatbotUser();
		appFrame = new ChatbotFrame(this); // passes a reference of the controller to the frame, so the GUI can pass on data back.
		appView = new BotView();
		appAI = new BotAI("ChatBot", "happy", "", this.theUser);
	}
	
	// method section:
	/**
	 * Directs the entire application
	 */
	public void start()
	{
		isRunning = true;
		
		while(isRunning)
		{
			
			
			
		}
//		while(!appAI.runQuitSequence())
//		{
//			appView.beginConversation();
//			name = appView.getName();
//			appAI.BotFirstReply(name);
//			responce = appAI.getResponce();
//			while(!appAI.runQuitSequence())
//			{
//				
//				appView.continueConversation(responce); 
//				input = appView.getInput();
//				
//				appAI.BotReply(input);
//				responce = appAI.getResponce();
//				
//			}
//		}
//		quit();
		
	}
	
	/**
	 * exits the program.
	 */
	private void quit()
	{
		closeMessage = "DON'T KILL ME!!!";
		appView.showMessage(closeMessage);
		System.exit(0);
		
	}
	
	public String startProcess(String input)
	{
		
		responce = appAI.BotReply(input);
		return responce;
		
	}

	
}
