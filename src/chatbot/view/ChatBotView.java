package chatbot.view;
import chatbot.model.ChatBot;
import javax.swing.JOptionPane;
/**
 * This is the screen for the Chatbot.
 * @author Spencer Davy
 * @version 1.2 10/15/13
 */
public class ChatBotView
{
	/**
	 * creates a chatbot named mychatbot.
	 */
	private ChatBot myChatBot;
	
	/**
	 * on the screen it creates a new chatbot for the chatbot called mychatbot. 
	 */
	public ChatBotView()
	{
	myChatBot = new ChatBot();
	}
	
	/**
	 * on the screen it shows what the code tells it to.
	 */
	public void ShowApp()
	{
		String answer = "keep going";
		
		while(answer == null || !answer.equals("no"))
		{
			JOptionPane.showMessageDialog(null,myChatBot.getRandomTopic());
			answer = GetInput();
			useInput(answer);
		
		}
	}
	/**
	 * 
	 * @return
	 */
	private String GetInput()
	 {
		 String userInput = "";
		 
		 userInput = JOptionPane.showInputDialog("Tell me something.");
		 
		 return userInput;
	 }
	
	
	private void useInput(String currentInput)
	{
		JOptionPane.showMessageDialog(null, "ok, tell me something else.");	
				if(myChatBot.memeChecker(currentInput))
				{
					JOptionPane.showMessageDialog(null, "you like memes huh?");		
				}
				
				if(myChatBot.movieChecker(currentInput))
				{
					JOptionPane.showMessageDialog(null, "you like movies huh?");	
				}
				else
				{
		
				}
	}
}
			

	