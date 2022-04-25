import java.util.List;
import java.util.ArrayList;
import java.util.*;

public abstract class Board {
    private static final String[] RANKS =
        {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
    private static final String[] SUITS = {"spades", "hearts", "diamonds", "clubs"};
    private Deck deck;
    private Card[] cards;
    private static final boolean I_AM_DEBUGGING = false;

    public Board(int size, int[] values) {
        cards = new Card[size];
        deck = new Deck(RANKS, SUITS, values);
        if (I_AM_DEBUGGING) {
            System.out.println(deck);
            System.out.println("----------");
        }
        dealMyCards();
    }

    public void newGame() {
        deck.shuffle();
        dealMyCards();
    }

    public int size() {
        return cards.length;
    }

    public boolean isEmpty() {
        for (int k = 0; k < cards.length; k++) {
            if (cards[k] != null) {
                return false;
            }
        }
        return true;
    }

    public void deal(int k) {
        cards[k] = deck.deal();
    }

    public int deckSize() {
        return deck.size();
    }

    public Card cardAt(int k) {
        return cards[k];
    }

    public void replaceSelectedCards(List<Integer> selectedCards) {
        for (Integer k : selectedCards) {
            deal(k.intValue());
        }
    }

    public List<Integer> cardIndexes() {
        List<Integer> cardIndexes = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != null) {
                cardIndexes.add(i);
            }
        }
        return cardIndexes;
    }

    public String toString() {
        String s = "";
        for (int k = 0; k < cards.length; k++) {
            s = s + k + ": " + cards[k] + "\n";
        }
        return s;
    }

    public boolean gameIsWon() {
        if (deck.isEmpty()) {
            for (Card c : cards) {
                if (c != null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public abstract boolean isLegal(List<Integer> selectedCards);

    public abstract boolean anotherPlayIsPossible();

    private void dealMyCards() {
        for (int k = 0; k < cards.length; k++) {
            cards[k] = deck.deal();
        }
    }
}