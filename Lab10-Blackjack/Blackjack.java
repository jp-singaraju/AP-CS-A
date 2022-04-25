import java.util.*;

public class Blackjack
{
    public static ArrayList<Card> makeDeck()
    {
        ArrayList<Card> list = new ArrayList<Card>();
        for (int rank = 1; rank <= 13; rank = rank + 1) {
            for (int suit = 0; suit <= 3; suit = suit + 1) {
                list.add(new Card(rank, suit));
            }
        }

        return list;
    }

    public static void swap(ArrayList<Card> cards, int i, int j)
    {
    	Card temp = cards.get(i);
    	cards.set(i, cards.get(j));
    	cards.set(j, temp);
    }

    public static void dealOneCard(ArrayList<Card> deck, ArrayList<Card> hand)
    {
    	Card card = deck.remove(0);
        hand.add(card);
    }

    public static int getScore(ArrayList<Card> hand)
    {
    	int total = 0;
    	for (Card card : hand) {
    	   if (card.getRank() == 1) {
    	       
    	   }
    	}
    	for (Card card : hand) {
    	    if (card.getRank() > 10) {
    	        total += 10;
    	    }
    	    else if (card.getRank() == 1) {
    	        int one = 21 - (total + 1);
    	        int eleven = 21 - (total + 11);
    	        if (one > eleven) {
    	            if (eleven >= 0) {
    	                total += 11;
    	            }
    	            else {
    	                total += 1;
    	            }
    	        } else {
    	            total += 1;
    	        }
    	    }
    	}
    	
        return total;
    }
}