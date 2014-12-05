package bot.view;


import javax.swing.JOptionPane;

import bot.controller.BotAppController;

/**
 *  A file from an old version. unused now.
 * @author dker2024
 * @version 1.0 10/2/14
 */
public class BotView
{
	
	// variable declaration:
	private String input;
	private String question;
	private String name;
	private BotAppController baseController;
	
	//constructor section:
	/**
	 * Blank constructor.
	 */
	public BotView()
	{
		
		
		
	}
	//method section:
	/**
	 * Starts the conversation to collect the name.
	 */
	public void beginConversation()
	{
		
		name = JOptionPane.showInputDialog(null, "Hello, what is your name?");
		
	}
	/**
	 * Continues the conversation with the user using the question parameter.
	 * @param question collects the question generated from the BotAI.
	 */
	public void continueConversation(String question)
	{
		
		this.question = question;
		
		input = JOptionPane.showInputDialog(null, question);
		
	}
	
	public void showMessage(String ChatbotMessage)
	{
		
		JOptionPane.showMessageDialog(null, ChatbotMessage);
		
	}
	/**
	 * Returns the name
	 * @return name 
	 */
	//getter section:
	public String getName()
	{
		return name;
	}
	/**
	 * Returns the input
	 * @return input
	 */
	public String getInput()
	{
		
		return input;
		
	}
	
}
