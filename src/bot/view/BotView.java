package bot.view;


import javax.swing.JOptionPane;

import bot.controller.BotAppController;

public class BotView
{
	
	// variable declaration:
	private String input;
	private String question;
	private String name;
	private BotAppController baseController;
	
	//constructor section:
	public BotView(BotAppController baseController)
	{
		
		this.baseController = baseController;
		
	}
	//method section:
	public void beginConversation()
	{
		
		name = JOptionPane.showInputDialog(null, "Hello, what is your name?");
		
	}
	
	public void continueConversation(String question)
	{
		
		this.question = question;
		
		input = JOptionPane.showInputDialog(null, question);
		
	}
	
	//getter section:
	public String getName()
	{
		return name;
	}
	
	public String getInput()
	{
		
		return input;
		
	}
	
}
