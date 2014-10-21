package bot.view;

import javax.swing.JFrame;

import bot.controller.BotAppController;

public class ChatbotFrame extends JFrame
{
	private ChatbotPanel basePanel;
	
	public ChatbotFrame(BotAppController baseController) 
	{
		basePanel = new ChatbotPanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		
		this.setContentPane(basePanel);
		this.setSize(400, 400);
		this.setResizable(true);
		setVisible(true);
		
	}

}
