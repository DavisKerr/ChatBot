package bot.controller;

import bot.model.BotAI;
import bot.view.BotView;


public class BotAppController
{

	// variable declaration section:
	private boolean isRunning;
	private BotView appView;
	private String input;
	private BotAI appAI;
	private String responce;
	private String name;
	
	// constructor section:
	public BotAppController()
	{
		
		appView = new BotView();
		appAI = new BotAI("ChatBot");
	}
	
	// method section:
	public void start()
	{
		isRunning = true;
		
		appView.beginConversation();
		
		name = appView.getName();
		
		appAI.BotFirstReply(name);
		responce = appAI.getResponce(); 
		while(isRunning == true)
		{
			
			appView.continueConversation(responce); 
			input = appView.getInput();
			
			if(input.equals("quit"))
			{
				quit();
			}
			appAI.BotReply(input);
			responce = appAI.getResponce();
			
		}
	}
	
	
	private void quit()
	{
		
		System.exit(0);
		
	}

}
