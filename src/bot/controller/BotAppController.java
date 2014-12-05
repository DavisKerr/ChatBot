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
	/**
	 * true if the program is running.
	 */
	private boolean isRunning;
	/**
	 * The basic popup window display.
	 */
	private BotView appView;
	/**
	 * The user's input.
	 */
	private String input;
	/**
	 * The AI for the chatbot.
	 */
	private BotAI appAI;
	/**
	 * What the computer types back.
	 */
	private String responce;
	/**
	 * What the computer says when the program exits.
	 */
	private String closeMessage;
	/**
	 * The gui frame.
	 */
	private ChatbotFrame appFrame;
	/**
	 * Collects and holds the users data.
	 */
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
		appAI = new BotAI("ChatBot", this.theUser);
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
	/**
	 * Runs the processText() method to find a responce, and sends the chosen responce back.
	 * @param input What the user typed in
	 * @return responce What the computer types back.
	 */
	public String startProcess(String input)
	{
		
		responce = appAI.processText(input);
		if(responce.equals("quiting"))
		{
			quit();
		}
		return responce;
		
	}

	
}
