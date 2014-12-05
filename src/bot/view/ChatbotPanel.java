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
import javax.swing.text.html.HTMLEditorKit;

public class ChatbotPanel extends JPanel
{
	/**
	 * The controller
	 */
	private BotAppController baseController;
	/**
	 * The button
	 */
	private JButton firstButton;
	/**
	 * The text field
	 */
	private JTextField firstTextField;
	/**
	 * The layout
	 */
	private SpringLayout baseLayout;
	/**
	 * The user's input.
	 */
	private String userInput;
	/**
	 * The users previous responces
	 */
	private JTextArea chatAreaUser;
	/**
	 * The scroll pane for chatAreaUser
	 */
	private JScrollPane chatPaneUser;
	/**
	 * The bot's previous responces
	 */
	private JTextArea chatAreaAi;
	/**
	 * the scroll pane for the chatAreaAi
	 */
	private JScrollPane chatPaneAi;
	/**
	 * The menu bar.
	 */
	private JMenuBar menuBar;
	/**
	 * The submenus
	 */
	private JMenu menu, submenu;
	/**
	 * The action submenus.
	 */
	private JMenu actionMenu, subMenu;
	/**
	 * menu item 1
	 */
	private JMenuItem menuItem;
	/**
	 * Menu item 2
	 */
	private JMenuItem menuItemFive;
	/**
	 * What to write.
	 */
	private String textToWrite;

	/**
	 * Constructs the panel and its elements.
	 * @param baseController The controller
	 */
	public ChatbotPanel(BotAppController baseController)
	{
		this.baseController = baseController;

		firstButton = new JButton("Submit Responce");
		firstTextField = new JTextField(25);
		baseLayout = new SpringLayout();
		
		menuBar = new JMenuBar();
		chatAreaUser = new JTextArea(5, 15);
		chatPaneUser = new JScrollPane(chatAreaUser);
		
		
		chatAreaAi = new JTextArea(5, 15);
		chatPaneAi = new JScrollPane(chatAreaAi);

		
		
		setupTextBox();
		setupMenu();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	/**
	 * Sets up the panel by adding the elements in.
	 */
	private void setupPanel()
	{

		this.setBackground(Color.GREEN);
		this.setSize(400, 400);
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
		this.add(chatPaneUser);
		this.add(menuBar);
		this.add(chatPaneAi);
	}
	
	/**
	 * positions the elements in the panel.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, chatPaneUser, 20, SpringLayout.SOUTH, menuBar);
		baseLayout.putConstraint(SpringLayout.WEST, chatPaneUser, 75, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatPaneUser, -6, SpringLayout.NORTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPaneAi, 51, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPaneAi, 6, SpringLayout.EAST, chatPaneUser);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatPaneAi, -6, SpringLayout.NORTH, firstTextField);
		baseLayout.putConstraint(SpringLayout.EAST, chatPaneAi, -75, SpringLayout.EAST, this);
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
	}
	
	/**
	 *Starts the listeners. 
	 */
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
				chatAreaUser.setForeground(Color.BLUE);
				chatAreaUser.setText(chatAreaUser.getText() + "\n \n" + firstTextField.getText());
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
	
	/**
	 * Sets up the chat areas preferences.
	 */
	private void setupTextBox()
	{
		
		chatAreaUser.setLineWrap(true);
		chatAreaUser.setWrapStyleWord(true);
		chatAreaUser.setEditable(false);
		
		chatAreaAi.setLineWrap(true);
		chatAreaAi.setWrapStyleWord(true);
		chatAreaAi.setEditable(false);

	}
	
	/**
	 * Sets up the menu.
	 */
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
	
	/**
	 * Returns the user input.
	 * @param userInput the users input.
	 * @return userInput.
	 */
	private String returnInput(String userInput)
	{
		this.userInput = userInput;
		return userInput;
	}
	
	/**
	 * sends the text to the controller and AI to be processed.
	 */
	private void sendText()
	{
		
		textToWrite = baseController.startProcess(userInput);
		chatAreaAi.setForeground(Color.RED);
		chatAreaAi.setText(chatAreaAi.getText() + "\n \n" + textToWrite);
		
	}
}
