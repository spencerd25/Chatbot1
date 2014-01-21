package chatbot.view;

import javax.swing.JFrame;

import chatbot.controller.ChatBotController;

public class ChatbotFrame extends JFrame
{
	/**
	 * @author Spencer Davy
	 */
	private static final long serialVersionUID = 1L;
	private ChatBotController baseController;
	private ChatbotPanel basePanel;
	
	public ChatbotFrame(ChatBotController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatbotPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(500,500);
		this.setVisible(true);
	}
}
