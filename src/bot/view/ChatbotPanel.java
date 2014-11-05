package bot.view;

import java.awt.Color;
import java.awt.MenuBar;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import bot.controller.BotAppController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class ChatbotPanel extends JPanel
{
	private BotAppController baseController;
	private JButton firstButton;
	private JTextField firstTextField;
	private SpringLayout baseLayout;
	private String userInput;
	private JTextArea chatAreaUser;
	private JScrollPane chatPaneUser;
	private JMenuBar menuBar;
	private JMenu menu, submenu;
	private JMenu actionMenu, subMenu;
	private JMenuItem menuItem;
	private JMenuItem menuItemFive;
	private String textToWrite;
	private JScrollPane chatpaneAI;
	private JTextArea chatAreaAI;

	public ChatbotPanel(BotAppController baseController)
	{
		this.baseController = baseController;

		firstButton = new JButton("Submit Responce");
		firstTextField = new JTextField(25);
		baseLayout = new SpringLayout();
		chatAreaAI = new JTextArea(5,15);
		chatpaneAI = new JScrollPane(chatAreaAI);
		
		
		
		

		
		menuBar = new JMenuBar();
		baseLayout.putConstraint(SpringLayout.NORTH, chatpaneAI, 41, SpringLayout.NORTH, menuBar);
		chatAreaUser = new JTextArea(5, 15);
		chatPaneUser = new JScrollPane(chatAreaUser);
		
		
		
				
		
		
		
		setupTextBox();
		setupMenu();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	

	private void setupPanel()
	{

		this.setBackground(Color.GREEN);
		this.setSize(400, 400);
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
		this.add(chatPaneUser);
		this.add(menuBar);
		this.add(chatpaneAI);
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, menuBar, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, menuBar, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextField, -224, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 120, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstButton, -131, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 100, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextField, -194, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, firstTextField, -110, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 6, SpringLayout.SOUTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstButton, -150, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatpaneAI, 200, SpringLayout.EAST, chatPaneUser);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPaneUser, 20, SpringLayout.SOUTH, menuBar);
		baseLayout.putConstraint(SpringLayout.WEST, chatPaneUser, 85, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatPaneUser, -6, SpringLayout.NORTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.EAST, chatPaneUser, -18, SpringLayout.WEST, chatpaneAI);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatpaneAI, -6, SpringLayout.NORTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.EAST, chatpaneAI, -86, SpringLayout.EAST, this);
	}

	private void setupListeners()
	{
		
		chatAreaUser.addFocusListener(new FocusListener()
		{

			@Override
			public void focusGained(FocusEvent focus) 
			{
			
				
				
			}
			
			@Override
			public void focusLost(FocusEvent focus)
			{
				
			}

			
			
			
		});

		firstButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent click)
			{
				
				userInput = firstTextField.getText();
				chatAreaUser.setText(chatAreaUser.getText() + "  " +firstTextField.getText());
				firstTextField.setText("");
				sendText();
			}
		});
		menuItem.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent click)
			{
				firstTextField.setText(firstTextField.getText() + "Quit");
			}
		});
		menuItemFive.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent click)
			{
				firstTextField.setText(firstTextField.getText() + "Quit");
			}
		});

	}
	
	private void setupTextBox()
	{
		
		chatAreaUser.setLineWrap(true);
		chatAreaUser.setWrapStyleWord(true);
		chatAreaUser.setEditable(false);
		
		chatAreaAI.setLineWrap(true);
		chatAreaAI.setWrapStyleWord(true);
		chatAreaAI.setEditable(false);
	}
	
	private void setupMenu()
	{
		
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		menuBar.add(menu);
		
		menuItem = new JMenuItem("Quit", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("Quits the program");
		menu.add(menuItem);
		
		actionMenu = new JMenu("Actions");
		actionMenu.setMnemonic(KeyEvent.VK_B);
		actionMenu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		menuBar.add(actionMenu);
		
		menuItemFive = new JMenuItem("High Five");
		menuItemFive.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, ActionEvent.ALT_MASK));
		menuItemFive.getAccessibleContext().setAccessibleDescription("Gives the chatbot a high five");
		actionMenu.add(menuItemFive);
		
	}
	
	private String returnInput(String userInput)
	{
		this.userInput = userInput;
		return userInput;
	}
	
	private void sendText()
	{
		
		textToWrite = baseController.startProcess(userInput);
		chatAreaUser.setText(chatAreaUser.getText() + "n/" + textToWrite);
		
	}
}
