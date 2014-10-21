package bot.view;

import javax.swing.JPanel;

import bot.controller.BotAppController;

public class ChatbotPanel extends JPanel
{
	private BotAppController baseController;
	
	public ChatbotPanel(BotAppController baseController)
	{
		this.baseController = baseController;
	}

}
