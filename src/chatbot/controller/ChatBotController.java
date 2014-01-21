package chatbot.controller;

import java.util.ArrayList;

import chatbot.model.ChatBot;
import chatbot.view.ChatBotView;
import chatbot.view.ChatbotFrame;

public class ChatBotController
{
	private ChatBot myChatbot;
	private ChatbotFrame appFrame;
	
	public ChatBotController()
	{
		myChatbot = new ChatBot();
	}
	
	public ChatBot getMyChatBot()
	{
		return myChatbot;
	}
	
public void start()
	{
		appFrame = new ChatbotFrame(this);
	}

	private String conversationHelper(ArrayList<String> conversationList)
	{
		String currentConversationPiece = "";
		
		if(conversationList.size() > 0)
		{
			currentConversationPiece = conversationList.remove(0);
		}
		
		return currentConversationPiece;
	}	
	

	public String processConversation()
	{
		String currentConversation = "";
		
		currentConversation = conversationHelper(myChatbot.topicConversation());
		
		return currentConversation;
	}

	public String processMeme(String currentInput)
	{
		String memeResponse = "response";
		
		if(myChatbot.memeChecker(currentInput))
		{
			return memeResponse = currentInput + "          I like that meme too.";
			
		}
		return memeResponse;
	}
	
	public String processMovies(String currentInput)
	{
		String movieResponse = "response";
		
		if(myChatbot.movieChecker(currentInput))
		{
			return movieResponse = currentInput + "          I like that movie too.";
			
		}
		return movieResponse;
	}
}
