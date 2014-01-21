package chatbot.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chatbot.controller.ChatBotController;
import chatbot.model.ChatBot;


public class ChatbotPanel extends JPanel
{
	/**
	 * @author Spencer Davy
	 */
	private static final long serialVersionUID = 1L;
	private ChatBotController baseController;
	private JButton submitButton;
	private JTextField userInputField;
	private JTextArea chatArea;
	private SpringLayout baseLayout;
	private ChatBot appBot;
	private JScrollPane textPane;
	private int clickCount;
	
	
	public ChatbotPanel(ChatBotController baseController)
	{
		this.baseController = baseController;
		this.appBot = baseController.getMyChatBot();
		
		submitButton = new JButton("Submit this to the Chatbot!");
		userInputField = new JTextField(30);
		baseLayout = new SpringLayout();
		
		chatArea = new JTextArea(10, 30);
		textPane = new JScrollPane(chatArea);
	
		
		clickCount = 0;
		
		setupPanel();
		setupLayout();
		setupListeners();
		
		startChat();
}

	private void startChat()
	{
		chatArea.setText(appBot.getRandomTopic());
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.MAGENTA);
		this.setLayout(baseLayout);
		this.add(submitButton);
		this.add(userInputField);
		this.add(textPane);
		
		
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, submitButton, 424, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, userInputField, 135, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, userInputField, -6, SpringLayout.NORTH, submitButton);
		baseLayout.putConstraint(SpringLayout.WEST, submitButton, 176, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, textPane, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, textPane, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, textPane, 380, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, textPane, -10, SpringLayout.EAST, this);
	}
	
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent click)
			{
				clickCount++;
				String currentInput = userInputField.getText();
				
				if(clickCount % 7 == 0)
				{
					String currentConversation = baseController.processConversation();
					if(currentConversation.length() != 0)
					{
						chatArea.append(currentConversation);
						clickCount--;
						}
					}
					else if(clickCount % 11 == 0)
					{
						chatArea.append(baseController.processMeme(currentInput));
					}
					else if(clickCount % 15 == 0)
					{
						chatArea.append(baseController.processMovies(currentInput));
					}
					else
					{
						chatArea.append("\n" + currentInput);
						chatArea.append("\n" + appBot.getRandomTopic());
			
					}
				}	
			
		});	
	}
}
