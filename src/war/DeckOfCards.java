package war;

//import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {
	//private static final SecureRandom randomNumbers = new SecureRandom();
	private static final int NUMBER_OF_CARDS = 52; // constant # of Cards

	private ArrayList<Card> deck = new ArrayList<Card>(NUMBER_OF_CARDS); // Card references
	private int currentCard = 0; // index of next Card to be dealt (0-51)

	// constructor fills deck of Cards
	public DeckOfCards() {
		String[] faces = {"Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
				"Queen", "King", "Ace"};
		String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
		
		// populate deck with Card objects
		for(String suit : suits)
		{
			for(int count = 0; count < faces.length; count++)
			{
				int val = count + 2;
				Card card = new Card(faces[count], suit, val);
				deck.add(card);
			}
		}
	}

	// shuffle deck of Cards with one-pass algorithm
	public void shuffle() 
	{
		// next call to method dealCard should start at deck[0] again
		currentCard = 0;
		Collections.shuffle(deck);
	}

	// deal one Card
	public Card dealCard() 
	{
		// determine whether Cards remain to be dealt
		if (currentCard < deck.size()) 
		{
			return deck.get(currentCard++); // return current Card in array
		} 
		else 
		{
			return null; // return null to indicate that all Cards were dealt
		}
	}
	
	
	public int getDeckSize() {
		return deck.size();
	}
	
	public Card getCard(int index) { 
		return deck.get(index);
	}
}