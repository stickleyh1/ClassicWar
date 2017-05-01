package deckOfCards;

import java.util.*;

/**
 * Class for a deck of cards. A deck of cards has an ArrayList of size 52 of
 * cards called deck.
 *
 * @author Howard
 */
public class DeckOfCards {

    private ArrayList<Card> deck;

    /**
     * Constructor for a DeckOfCards
     */
    public DeckOfCards() {
        deck = new ArrayList<Card>();
        for (int i = 1; i <= 13; i++) {
            deck.add(new Card(i, Suit.SPADES));
            deck.add(new Card(i, Suit.HEARTS));
            deck.add(new Card(i, Suit.DIAMONDS));
            deck.add(new Card(i, Suit.CLUBS));
        }
    }

    /**
     * Randomizes the deck.
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * Returns the top card on the deck
     *
     * @return the top card on the deck
     */
    public Card peekTopCard() {
        return deck.get(deck.size() - 1);
    }

    /**
     * Returns the card removed from the deck
     *
     * @return the card removed from the deck
     */
    public Card drawTopCard() {
        return deck.remove(deck.size() - 1);
    }

    /**
     * Returns the size of the deck
     *
     * @return the size of the deck
     */
    public int size() {
        return deck.size();
    }

    /**
     * Returns the if the deck is empty
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return deck.isEmpty();
    }

    /**
     * Returns the ArrayList of Cards as a String
     *
     * @return the ArrayList of Cards as a String
     */
    @Override
    public String toString() {
        return "DeckOfCards [deck=" + deck + "]";
    }
}
