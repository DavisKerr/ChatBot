package bot.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import bot.controller.BotAppController;

public class ChatbotPanel extends JPanel
{
	private BotAppController baseController;
	private JButton firstButton; 
	private JTextField firstTextField;
	private SpringLayout baseLayout;

	public ChatbotPanel(BotAppController baseController)
	{	
		this.baseController = baseController;
		
		firstButton = new JButton("CLICK ME OR DIE!!!");
		firstTextField = new JTextField(25);
		baseLayout = new SpringLayout();
		
		
				
		
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		
		this.setBackground(Color.MAGENTA);
		this.setSize(400, 400);
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
		
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 112, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextField, -30, SpringLayout.NORTH, firstButton);
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 155, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstButton, -10, SpringLayout.SOUTH, this);
	}

	private void setupListeners()
	{
		
		
		
	}

}
