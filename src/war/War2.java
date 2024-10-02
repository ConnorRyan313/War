//package war;
//
//import java.util.ArrayList;
//
//public class War2 
//{
//	public void compareCard(ArrayList<Card> p1, ArrayList<Card> p2, ArrayList<Card> p1Win, ArrayList<Card> p2Win) {
//		this.player1Deck = p1;
//		this.player2Deck = p2;
//		this.p1WinningDeck = p1Win;
//		this.p2WinningDeck = p2Win;
//		
//		//checks to see if decks reaches 0
//		rewriteDeck(p1, p1WinningDeck);
//		rewriteDeck(p2, p2WinningDeck);
//				
//		Card player1Card = p1.get(0);
//		Card player2Card = p2.get(0);
//		int player1Value = player1Card.getValue();
//		int player2Value = player2Card.getValue();
//
//		System.out.println("Player 1 Card:");
//		printCard(player1Card);
//		System.out.println("Player 2 Card:");
//		printCard(player2Card);
//
//		if (player1Value > player2Value) {
//			System.out.println("Player 1 gets both cards!");
//			p1.remove(0);
//			p2.remove(0);
//			p1Win.add(player1Card);
//			p1Win.add(player2Card);
//		} else if (player2Value > player1Value) {
//			System.out.println("Player 2 gets both cards!");
//			p1.remove(0);
//			p2.remove(0);
//			p2Win.add(player1Card);
//			p2Win.add(player2Card);
//		} else {
//			WarTime(p1, p2, p1Win, p2Win);
//			checkForWar();
//		}
//		System.out.println("Player 1's Deck: " + (player1Deck.size() + p1WinningDeck.size()) + " cards");
//		System.out.println("Player 2's Deck: " + (player2Deck.size() + p2WinningDeck.size()) + " cards");
//	}
//}
