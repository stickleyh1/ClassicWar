package cardGame;

import java.util.*;
import deckOfCards.*;

/**
 * Class representing a player.
 * A player has a Queue of cards called deck
 * 
 * @author Howard
 */
public class Player {

    public Queue<Card> deck;

    /**
     * Default constructor for class Player
     */
    public Player(){
        this.deck = new LinkedList<Card>();
    }
    
    /**
     * Constructor for class Player
     */
    public Player(Queue<Card> deck) {
        this.deck = deck;
    }

    public Queue<Card> getDeck() {
        return deck;
    }
    
    public void addToDeck(Card card){
        deck.add(card);
    }
    
    public void addToDeck(ArrayList<Card> cards){
        for(int i = 0; i < cards.size(); i++){
            deck.add(cards.remove(i));
        }
    }
    
    /**
     * Returns the top card on the player's activePile and discardPile as a String.
     * Returns the size of the player's activePile and discardPile as a String.
     * Returns the player's defending status as a String.
     * 
     * @return  the top card on the player's activePile and discardPile as a String.
     * @return  the size of the player's activePile and discardPile as a String.
     * @return  the player's defending status as a String.
     */
    @Override
    public String toString() {
        String result = "";
        if (!deck.isEmpty()) {
            result += "Card Played = " + deck.peek() + "\n";
            result += "deck Size = " + deck.size() + "\n";
        }
        else{
            result += "Deck is empty \n";
        }
        return result;
    }
}