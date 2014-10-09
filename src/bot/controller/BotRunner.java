package bot.controller;

/**
 * The runner of the ChatBot
 * @author Davis Kerr
 * @version 1.0 10/7/14
 */
public class BotRunner
{
	/**
	 *Starting point for all java programs 
	 * @param args Unused
	 */
	public static void main(String[] args)
	{
		
		BotAppController appController = new BotAppController();
		appController.start();

	}

}
