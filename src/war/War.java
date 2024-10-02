/*
 * Connor Ryan and Cole Davignon
 * 4/28/2023
 * SER Final Project
 * Simulates a whole game of the card game, War
 */
package war;

import java.util.ArrayList;
import java.util.Scanner;

public class War extends DeckOfCards 
{
	//creates 4 decks, each player's deck they are using, and then their decks that hold their collected cards
	private ArrayList<Card> player1Deck;
	private ArrayList<Card> player2Deck;
	private ArrayList<Card> p1WinningDeck;
	private ArrayList<Card> p2WinningDeck;
	//boolean that checks if game is over
	private boolean gameOver;
	//counts total rounds
	private int totalRounds;

	//default constructor
	public War() 
	{
		player1Deck = new ArrayList<Card>();
		player2Deck = new ArrayList<Card>();
		p1WinningDeck = new ArrayList<Card>();
		p2WinningDeck = new ArrayList<Card>();
		gameOver = false;
		totalRounds = 0;
	}
	//method that plays the game
	public void playGame() 
	{
		//displays rules
		displayRules();
		//splits the deck between decks
		splitDeck(player1Deck, player2Deck);
		//scanner that allows game to play each turn and input if needed
		Scanner scan = new Scanner(System.in);
		while ((player1Deck.size() + p1WinningDeck.size()) < 52 || (player2Deck.size() + p2WinningDeck.size()) < 52 || gameOver == false) 
		{
			//increments total rounds
			totalRounds++;
			//allows for input to end game
			String input = scan.nextLine();
			//conditional for game to manually end
			if (input.equals("end")) 
			{
				System.out.println("Thanks for playing!");
				break;
			}
			//compares card values
			compareCard(player1Deck, player2Deck, p1WinningDeck, p2WinningDeck);
			//prints total rounds after each card is compared
			System.out.println("Total Rounds: " + totalRounds);
			//checks if the decks have enough cards to proceed			
			if((player1Deck.size() + p1WinningDeck.size()) == 52)
			{
				System.out.println("Player 1 Wins!");
				break;
			}
			else if((player2Deck.size() + p2WinningDeck.size()) == 52)
			{
				System.out.println("Player 2 Wins!");
				break;
			}
			//forces game to be over from possible exceptions
			if(gameOver == true)
			{
				break;
			}
			//prints each players' deck
			System.out.println("Player 1's Deck: " + (player1Deck.size() + p1WinningDeck.size()) + " cards");
			System.out.println("Player 2's Deck: " + (player2Deck.size() + p2WinningDeck.size()) + " cards");
		}
		scan.close();
	}
	//splits deck to both player decks
	public static void splitDeck(ArrayList<Card> deck1, ArrayList<Card> deck2) 
	{
		//creates deck of card object
		DeckOfCards deck3 = new DeckOfCards();
		//shuffles
		deck3.shuffle();
		//for loop to add to each deck
		for (int count = 0; count < deck3.getDeckSize(); count++) 
		{
			//if index is mod 2, then add to player 1
			if (count % 2 == 0) 
			{
				deck1.add(deck3.getCard(count));
			}
			//else player 2
			else 
			{
				deck2.add(deck3.getCard(count));
			}
		}
	}

	public void compareCard(ArrayList<Card> p1, ArrayList<Card> p2, ArrayList<Card> p1Win, ArrayList<Card> p2Win) 
	{
		//sets each instance to arguments
		this.player1Deck = p1;
		this.player2Deck = p2;
		this.p1WinningDeck = p1Win;
		this.p2WinningDeck = p2Win;
		
		//checks to see if decks reaches 0
		rewriteDeck(p1, p1WinningDeck);
		rewriteDeck(p2, p2WinningDeck);
		
		//card variables of 1st index of each list
		Card player1Card = p1.get(0);
		Card player2Card = p2.get(0);
		//gets each value of each card at top of deck
		int player1Value = player1Card.getValue();
		int player2Value = player2Card.getValue();
		//prints each card
		System.out.println("Player 1 Card:");
		printCard(player1Card);
		System.out.println("Player 2 Card:");
		printCard(player2Card);
		//compares each card value, if player 1 > player 2, they win
		if (player1Value > player2Value) 
		{
			System.out.println("Player 1 gets both cards!");
			//removes each card at top of deck, then adds to winner deck
			p1.remove(0);
			p2.remove(0);
			p1Win.add(player1Card);
			p1Win.add(player2Card);
		} 
		//else, player 2 > player 1
		else if (player2Value > player1Value) 
		{
			System.out.println("Player 2 gets both cards!");
			//removes each card at top of deck, then adds to winner deck
			p1.remove(0);
			p2.remove(0);
			p2Win.add(player1Card);
			p2Win.add(player2Card);
		} 
		//else, it's war!
		else 
		{
			WarTime(p1, p2, p1Win, p2Win);
		}
	}
	//compares cards after each war
	public void WarTime(ArrayList<Card> p1, ArrayList<Card> p2, ArrayList<Card> p1Win, ArrayList<Card> p2Win) 
	{
		System.out.println("THIS IS WAR!");
		this.player1Deck = p1;
		this.player2Deck = p2;
		this.p1WinningDeck = p1Win;
		this.p2WinningDeck = p2Win;
		//try-catch to in case they have less cards needed for a war
		try
		{
			//gets card at 4th index, imitating war
			Card player1Card = p1.get(4);
			Card player2Card = p2.get(4);
			//gets value again
			int player1Value = player1Card.getValue();
			int player2Value = player2Card.getValue();
			//prints war cards
			System.out.println("Player 1's War Card:");
			printCard(player1Card);
			System.out.println("Player 2's War Card:");
			printCard(player2Card);
			//if player 1 is greater than 2
			if (player1Value > player2Value) 
			{
				System.out.println("Player 1 gets all cards!");
				for (int count = 0; count < 4; count++) 
				{
					//removes at top of deck
					p1.remove(0);
					p2.remove(0);
					//adds each at each index in the loop, 4 times total
					p1Win.add(player1Deck.get(count));
					p1Win.add(player2Deck.get(count));
				}
			} 
			//if player 2 is greater than 1
			else if (player2Value > player1Value) 
			{
				System.out.println("Player 2 gets all cards!");
				for (int count = 0; count < 4; count++) 
				{
					//does same as player 1's loop
					p1.remove(0);
					p2.remove(0);
					p2Win.add(player1Deck.get(count));
					p2Win.add(player2Deck.get(count));
				}
			}
			//checks for double war
			else
			{
				doubleWar(p1, p2, p1Win, p2Win);
			}
		}
		//catches a out of bounds if they have less cards needed for a war
		catch(IndexOutOfBoundsException ie)
		{
			if((p1.size() + p1Win.size()) > (p2.size() + p2Win.size()))
			{
				//shows who had more cards and why game ended
				System.out.println("Player 1 Wins!");
				System.out.println("Player 2 did not have enough cards to get a war, making player 1 win.");
			}
			else
			{
				System.out.println("Player 2 Wins!");
				System.out.println("Player 1 did not have enough cards to get a war, making player 2 win.");
				
			}
			//makes game over true for while loop
			gameOver = true;
		}
		
	}
	//compares cards if 2 wars in a row
	public void doubleWar(ArrayList<Card> p1, ArrayList<Card> p2, ArrayList<Card> p1Win, ArrayList<Card> p2Win)
	{
		System.out.println("THIS IS A DOUBLE WAR!!!!!");
		this.player1Deck = p1;
		this.player2Deck = p2;
		this.p1WinningDeck = p1Win;
		this.p2WinningDeck = p2Win;
		//another try-catch if they have less cards than needed
		try
		{
			//gets at 8th index, since it is the 8th card compared for a double war
			Card player1Card = p1.get(8);
			Card player2Card = p2.get(8);
			//gets value
			int player1Value = player1Card.getValue();
			int player2Value = player2Card.getValue();
			//prints war card for double war
			System.out.println("Player 1's War Card:");
			printCard(player1Card);
			System.out.println("Player 2's War Card:");
			printCard(player2Card);
			//another comparison, if 1 > 2
			if (player1Value > player2Value) 
			{
				System.out.println("Player 1 gets all cards!");
				for (int count = 0; count < 8; count++) 
				{
					//removes at top of deck
					p1.remove(0);
					p2.remove(0);
					//adds each card in loop
					p1Win.add(player1Deck.get(count));
					p1Win.add(player2Deck.get(count));
				}
			} 
			else if (player2Value > player1Value) 
			{
				System.out.println("Player 2 gets all cards!");
				for (int count = 0; count < 8; count++) {
					//removes at top of deck
					p1.remove(0);
					p2.remove(0);
					//adds each card in loop
					p2Win.add(player1Deck.get(count));
					p2Win.add(player2Deck.get(count));
				}
			}
		}
		//another catch for index out of bounds
		catch(IndexOutOfBoundsException ie)
		{
			if((p1.size() + p1Win.size()) > (p2.size() + p2Win.size()))
			{
				//player 2 ran out of cards
				System.out.println("Player 1 Wins!");
				System.out.println("Player 2 did not have enough cards to get a war, making player 1 win.");
			}
			else
			{
				//player 1 ran out of cards
				System.out.println("Player 2 Wins!");
				System.out.println("Player 1 did not have enough cards to get a war, making player 2 win.");
			}
			//sets game over to true for while loop
			gameOver = true;
		}
		
	}
	//rewrites deck when deck being used is 0
	public static void rewriteDeck(ArrayList<Card> deck, ArrayList<Card> winningDeck) {
			for(int index = 0; index < winningDeck.size(); index++) 
			{
				//populates playing deck with cards from winning deck
				deck.add(winningDeck.get(index));
				//removes cards from index, no duplicate cards
				winningDeck.remove(index);
			}
	}
	//prints each card based on suits and numbers
	public static void printCard(Card card) 
	{
		int value = card.getValue();
		String suit = card.getSuit();
		String face = " ";
		if (suit == "Hearts") 
		{
			 //H means Heads on card
			suit = "H";
		} 
		else if (suit == "Diamonds") 
		{
			//D means Diamonds
			suit = "D";
		} 
		else if (suit == "Clubs") 
		{
			//C means Clubs
			suit = "C";
		} 
		else 
		{
			//S means Spades
			suit = "S";
		}
		//switch case based on card value for face cards
		if (value > 10) 
		{
			switch (value) 
			{
			case 11:
				face = "J"; // jack
				break;
			case 12:
				face = "Q"; // queen
				break;
			case 13:
				face = "K"; // king
				break;
			default:
				face = "A"; // ace
				break;
			}
			//prints each card with dashes
			System.out.printf(" ____\n|" + suit + "  " + face + "| \n|    |\n|    |\n|" + face + "__" + suit + "|\n");
		} 
		else if (value == 10)
		{
			System.out.printf(" ____\n|" + suit + " " + value + "| \n|    |\n|    |\n|" + value + "_" + suit + "|\n");
		} 
		else 
		{
			System.out.printf(" ____\n|" + suit + "  " + value + "| \n|    |\n|    |\n|" + value + "__" + suit + "|\n");
		}
	}
	//displays rules of game
	public void displayRules() 
	{
		System.out.println("Welcome to War! This is a card game implemented by Connor Ryan and Cole Davignon.");
		System.out.println("Rules: \n1. The main deck of cards gets split evenly to two players.");
		System.out.println("2. Each player plays a card, whichever player places a higher value card receives both cards.");
		System.out.println("3. First person to get the whole deck wins the game!");
		System.out.println("4. If the players place a card of equal value, that means WAR. The players must then place 3 more cards, then when the 4th card gets placed, those cards get compared.");
		System.out.println("Whoever's 4th card has the highest value takes EVERY CARD!!");
		System.out.println("If you want to force end the game, type 'end'. Otherwise, press enter.");
	}
}
