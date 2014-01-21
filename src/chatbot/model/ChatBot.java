package chatbot.model;

import java.util.ArrayList;

/**
 * This is a Chatbot
 * 
 * @author Spencer Davy
 * @version 1.4 10/15/13
 * 
 */
public class ChatBot
{
	/**
	 * A list of specific memes.
	 */
	private ArrayList<String> myMemes;
	/**
	 * A list of specific movies.
	 */
	private ArrayList<String> Movies;
	/**
	 * An ArrayList of Strings to hold random topics.
	 */
	private ArrayList<String> randomList;

	private ArrayList<String> conversationList;

	public ChatBot()
	{
		myMemes = new ArrayList<String>();
		Movies = new ArrayList<String>();
		MoviesList();
		conversationList = new ArrayList<String>();
		randomList = new ArrayList<String>();
		fillTheMemeList();
		fillTheRandomList();
		fillTheConversationList();
	}

	/**
	 * Fills the randomList with various Strings for the chatbot.
	 */
	private void fillTheRandomList()
	{
		randomList.add("i like cheese.");
		randomList.add("i hate essays.");
		randomList.add("i like cereal.");
		randomList.add("This is random.");
		randomList.add("i am a programmer.");
		randomList.add("i like typing.");
	}

	public String getRandomTopic()
	{
		String randomTopic = "";

		double myRandom = Math.random();
		int myRandomListPosition = (int) (myRandom * randomList.size());
		randomTopic = randomList.get(myRandomListPosition);

		return randomTopic;
	}

	/**
	 * adds a list of Movies.
	 */
	private void MoviesList()
	{
		Movies.add("Iron Man 3");
		Movies.add("Incredibles");
		Movies.add("Bolt");
		Movies.add("up");
		Movies.add("despicable me 2");
	}

	/**
	 * adds a list of memes.
	 */
	private void fillTheMemeList()
	{
		myMemes.add("nicolas cage");
		myMemes.add("arrow to the knee");
		myMemes.add("one does not simply");
		myMemes.add("y u no");
	}

	private void fillTheConversationList()
	{
		conversationList.add("       hi how are you");
		conversationList.add("       what are you talking about");
		conversationList.add("       what do you know anyway?");
	}

	/**
	 * checks if you typed in one of the movies on the movie list.
	 * 
	 * @param currentInput
	 * @return
	 */
	public boolean movieChecker(String currentInput)
	{
		boolean movieChecker = false;

		if (currentInput != null)
			;
		for (String currentPhrase : Movies)
		{
			if (currentPhrase.equalsIgnoreCase(currentInput))
			{
				movieChecker = true;
			}
		}
		return movieChecker;
	}

	/**
	 * checks if you typed one of the memes on the meme list.
	 * 
	 * @param currentInput
	 * @return
	 */
	public String contentBased(String currentInput)
	{
		String processed = "";

		if (currentInput.contains("boo"))
		{
			processed = "ooooh scary";
		}
		else
		{
			processed = "not scary";
		}
		return processed;
	}

	public ArrayList<String> topicConversation()
	{
		return conversationList;
	}


	public boolean memeChecker(String currentInput)
	{
		boolean hasMeme = false;
		// loop over all the items in the list, if the input matches a meme,
		// change hasMeme to true.

		if (currentInput != null)
			;
		{
			for (String currentPhrase : myMemes)
			{
				if (currentPhrase.equalsIgnoreCase(currentInput))
				{
					hasMeme = true;
				}
			}
			return hasMeme;

		}
	}
}
