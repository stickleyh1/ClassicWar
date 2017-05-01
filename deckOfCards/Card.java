package deckOfCards;

/**
 * A card has a rank, 2-10, JACK, QUEEN, KING, ACE.
 * A card has a suit, SPADES, HEARTS, DIAMONDS, CLUBS.
 * 
 * @author Howard
 */
public class Card {
	public final int JACK = 11;
	public final int QUEEN = 12;
	public final int KING = 13;
	public final int ACE = 1;
	private int rank;
	private Suit suit;

        /**
         * Default Constructor for Card.
         * 
         * @param rank the card's rank.
         * @param suit the card's suit.
         */
	public Card(int rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;		
	}
	
        /**
         * Constructor for Card.
         * 
         * @param cardName the specific card to be created.
         */
	public Card(String cardName) {
		char suitChar = cardName.charAt(cardName.length()-1);
		switch(suitChar) {
			case 'S': this.suit = Suit.SPADES; break;
			case 'H': this.suit = Suit.HEARTS; break;
			case 'D': this.suit = Suit.DIAMONDS; break;
			case 'C': this.suit = Suit.CLUBS; break;
			default: this.suit = Suit.SPADES; break;			
		}
		String rank = cardName.substring(0, cardName.length()-1);
		if (rank.equals("J"))
			this.rank = JACK;
		else if (rank.equals("Q"))
			this.rank = QUEEN;
		else if (rank.equals("K"))
			this.rank = KING;
		else if (rank.equals("A"))
			this.rank = ACE;
		else
			this.rank = Integer.parseInt(rank);
	}

        /**
         * Returns the rank of the card
         * 
         * @return the rank of the card.
         */
	public int getRank() {
		return rank;
	}

        /**
         * Returns the suit of the card.
         * 
         * @return the suit of the card.
         */
	public Suit getSuit() {
		return suit;
	}

        /**
         * Checks if the current card is equal to another.
         * 
         * @param other the card to be compared to.
         * @return true if the cards are equal, otherwise return false.
         */
	public boolean equals(Card other) {
		return ((this.rank == other.rank) && (this.suit == other.suit));
	}
	
        /**
         * Compares the ranks of two cards, if they are unequal
         * then return the difference between the current card and the one 
         * it is being compared to.
         * 
         * If they are equal in rank then compare the suits.
         * 
         * @param other the card to be compared to
         * @return the difference between the current card 
         * and the on being compared to or the difference of the suits.
         */
	public int compareTo(Card other) {
		if (this.rank != other.rank)
			return (this.rank - other.rank);
		else {
			return (this.suit.toString().compareTo(other.suit.toString()));
		}			
	}
	
        /**
         * Return the difference in the two cards ranks.
         * 
         * @param other the card to be compared to.
         * @return the difference in the two cards ranks.
         */
	public int compareRank(Card other) {
		return (this.rank - other.rank);	
	}

        /**
         * If the current card is an ace and the other is not then return 1.
         * If the other card is an ace and the current is not then return -1.
         * 
         * If neither cards are aces then return the difference of their ranks.
         * 
         * @param other the card to be compared to
         * @return 
         */
	public int compareRankAceHigh(Card other) {
		if (this.rank == ACE && other.rank != ACE)
			return 1;
		else if (this.rank != ACE && other.rank == ACE)
			return -1;
		else return compareRank(other);	
	}
	
        /**
         * Returns either the rank or suit of the card as a String
         * 
         * @return the rank or suit of the card as a String
         */
	@Override
	public String toString() {
		String result = "";
		switch (rank) {
			case ACE: result = "Ace"; break;
			case JACK: result = "Jack"; break;
			case QUEEN: result = "Queen"; break;
			case KING: result = "King"; break;
			default: result = Integer.toString(rank); break;
		}
		switch (suit) {
			case SPADES: result += " of Spades"; break;
			case HEARTS: result += " of Hearts"; break;
			case DIAMONDS: result += " of Diamonds"; break;
			case CLUBS: result += " of Clubs"; break;
		}
		return result;
	}
}
