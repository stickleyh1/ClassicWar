package cardGame;

import java.util.*;
import deckOfCards.*;

/**
 * A class representing a Card Game. A CardGame has an ArrayList of Players
 * called players. A CardGame has a DeckOfCards called deck.
 *
 * @author Howard
 */
public class CardGame {

    public ArrayList<Player> players;
    public ArrayList<Boolean> losers;
    private DeckOfCards deck;
    private int round = 1;

    /**
     * Constructor for the CardGame.
     */
    public CardGame() {
        players = new ArrayList<Player>();
        losers = new ArrayList<Boolean>();
        deck = new DeckOfCards();
    }

    /**
     * Shuffles the deck. Deals the given number of cards to each player. Runs
     * the entire game. Controls the current turns. Stops when only one player
     * has cards.
     *
     * @param numPlayers the number of players in the game
     */
    public void play(int numPlayers) {
        boolean done = false;

        deal(numPlayers);
        int winner = 0;

        while (!done) {
            System.out.println(this);
            playRound();

            int playersRemaining = 0;
            for (int i = 0; i < numPlayers; i++) {
                if (!losers.get(i)) {
                    winner = i;
                    playersRemaining++;
                }
            }
            if (playersRemaining == 1) {
                done = true;
            } else {
                round++;
            }
        }
        System.out.println("Player " + (winner + 1) + " wins!");
    }

    /**
     * Plays a single round of War.
     */
    public void playRound() {
        ArrayList<Card> cardsToCompare = new ArrayList<Card>();

        for (int i = 0; i < players.size(); i++) {
            if (!losers.get(i)) {
                if (players.get(i).deck.isEmpty()) {
                    losers.set(i, Boolean.TRUE);
                    break;
                } else {
                    cardsToCompare.add(players.get(i).deck.poll());
                }
            } else {
                cardsToCompare.add(new Card(0, Suit.SPADES));
            }
        }
        compareCards(cardsToCompare, new ArrayList<Card>(), new ArrayList<Integer>());
    }

    /**
     * Compares the cards, adds loser to winner, if tied goes to tiebreaker.
     *
     * @param cards - the cards to be compared
     * @param transferCards - the losing cards
     */
    public void compareCards(ArrayList<Card> cards, ArrayList<Card> transferCards, ArrayList<Integer> indexes) {
        Card highestCard = new Card(0, Suit.SPADES);
        int winningPlayer = 0;
        ArrayList<Integer> tieIndexes = new ArrayList<Integer>();

        if (cards.size() != 1) {
            for (Card card : cards) {
                if (!transferCards.contains(card)) {
                    if (card.getRank() != 0) {
                        transferCards.add(card);
                    }
                }
            }

            for (int i = 0; i < cards.size(); i++) {
                if (cards.get(i).getRank() != 0) {
                    if (highestCard.compareRankAceHigh(cards.get(i)) < 0) {
                        highestCard = cards.get(i);
                        winningPlayer = i;
                    } else if (highestCard.compareRankAceHigh(cards.get(i)) == 0) {
                        tieIndexes.add(i);
                    }
                }
            }

            for (int i = 0; i < tieIndexes.size(); i++) {
                if (highestCard.compareRankAceHigh(cards.get(tieIndexes.get(i))) != 0 || highestCard.compareRankAceHigh(cards.get(tieIndexes.get(i))) > 0) {
                    tieIndexes.remove(i);
                }
            }
        }

        if (!tieIndexes.isEmpty()) {
            tieIndexes.add(winningPlayer);
            tieBreaker(tieIndexes, transferCards);
        } else {
            if (indexes.isEmpty()) {
                players.get(winningPlayer).deck.addAll(transferCards);
            } else {
                players.get(indexes.get(winningPlayer)).deck.addAll(transferCards);
            }
        }
    }

    /**
     * Runs the tiebreaker.
     *
     * @param indexes - the player equivalent indexes
     * @param transferCards - the losing cards
     */
    public void tieBreaker(ArrayList<Integer> indexes, ArrayList<Card> transferCards) {
        for (int i = 0; i < indexes.size(); i++) {
            for (int j = 0; j < 3; j++) {
                if (players.get(i).deck.isEmpty()) {
                    losers.set(i, Boolean.TRUE);
                    break;
                } else {
                    transferCards.add(players.get(i).deck.poll());
                }
            }
        }

        ArrayList<Card> cards = new ArrayList<Card>();
        for (int i = 0; i < indexes.size(); i++) {
            if (!losers.get(indexes.get(i))) {
                if (players.get(i).deck.isEmpty()) {
                    losers.set(i, Boolean.TRUE);
                    break;
                } else {
                    
                    cards.add(players.get(indexes.get(i)).deck.poll());
                }
            }
        }

//        if (cards.size() > 1) {
        compareCards(cards, transferCards, indexes);
//        } else {
//            for (int i = 0; i < indexes.size(); i++) {
//                if (!players.get(i).deck.isEmpty()) {
//                    players.get(indexes.get(i)).deck.addAll(transferCards);
//                }
//            }
//        }
    }

    /**
     * Deals in each player.
     *
     * @param numPlayers - the number of players in the game
     */
    public void deal(int numPlayers) {
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player());
            losers.add(Boolean.FALSE);
        }

        for (int i = 0; i < 8; i++) {
            deck.shuffle();
        }

        while (!deck.isEmpty()) {
            for (int i = 0; i < numPlayers; i++) {
                System.out.println(deck);
                if (deck.isEmpty()) {
                    break;
                }
                players.get(i).addToDeck(deck.drawTopCard());
            }
        }
    }

    /**
     * Returns all the players as a String.
     *
     * @return all the players as a String.
     */
    @Override
    public String toString() {
        String result = "Round " + round;
        for (int i = 0; i < players.size(); i++) {
            result += "\nPlayer " + (i + 1) + ": " + players.get(i).toString();
        }
        result += "-------------------------------------------------------------";
        return result;
    }
}
