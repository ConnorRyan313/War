package war;

import java.util.ArrayList;

public class CardStack 
{
	private int numCards;
	private ArrayList<Card> cards;
	private int top;
	
	//default constructor
	public CardStack()
	{
		cards = new ArrayList<Card>(52);
		numCards = 0;
		top = 0;
	}
	
	//pushes the number to the top of the stack, increases numCards
	public void push(Card card) 
	{
		top++;
		cards.add(card);
		numCards++;
	}
	
	//checks if the stack is empty
	public boolean isEmpty()
	{
		return top == -1;
	}
	
	//pops top item out of stack, decreases numCards
	public Card pop()
	{
		Card card = cards.get(top);
		cards.remove(top);
		top--;
		numCards--;
		return card;
	}
	
	
	//shows top of stack
	public Card peek()
	{
		return cards.get(top);
	}
	
	//returns size of stack
	public int size()
	{
		return numCards;
	}
}
