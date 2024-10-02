package war;

public class Card {
	private final String face; // face of card ("Ace", "Deuce", ...)
	private final String suit; // suit of card ("Hearts", "Diamonds", ...)
	private final int value;

	// two-argument constructor initializes card's face and suit
	public Card(String cardFace, String cardSuit, int cardValue) {
		this.face = cardFace; // initialize face of card
		this.suit = cardSuit; // initialize suit of card
		this.value = cardValue; //initializes value of each card
		
	}

	// return String representation of Card
	public String toString() {
		return face + " of " + suit + " Value: " + value + " ";
	}
	
	public String getFace() {
		return face;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getSuit() {
		return suit;
	}
}