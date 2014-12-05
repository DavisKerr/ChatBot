package bot.view;

import javax.swing.JFrame;

import bot.controller.BotAppController;
/**
 * The frame for the GUI.
 *@author Davis Kerr
 *@version 1.0
 */
public class ChatbotFrame extends JFrame
{
	/**
	 * The panel.
	 */
	private ChatbotPanel basePanel;
	
	/**
	 * Constructor that builds the GUI.
	 * @param baseController
	 */
	public ChatbotFrame(BotAppController baseController) 
	{
		basePanel = new ChatbotPanel(baseController);
		setupFrame();
	}
	
	/**
	 * Sets up the frame.
	 */
	private void setupFrame()
	{
		
		this.setContentPane(basePanel);
		this.setSize(500, 500);
		this.setResizable(false);
		setVisible(true);
		
	}

}
