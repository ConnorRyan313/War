package war;

public class CardDisplayTest {

	public static void main(String[] args) {

	}

	
	public static void printCard(Card card) {
		int value = card.getValue();
		String suit = card.getSuit();
		
		String face = " ";
		if(suit == "Hearts") 
		{
			suit = "H";
		}
		else if(suit == "Diamonds")
		{
			suit = "D";
		}
		else if(suit == "Clubs")
		{
			suit = "C";
		}
		else
		{
			suit = "S";
		}
		
		if(value > 10) {
			switch(value) {
			case 11:
				face = "J"; //jack
				break;
			case 12:
				face = "Q"; //queen
				break;
			case 13:
				face = "K"; //king
				break;
			default:
				face = "A"; //ace
				break;
			}
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
}
