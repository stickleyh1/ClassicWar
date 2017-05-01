package deckOfCards;

public class TestDriver {

	public static void main(String[] args) {
		DeckOfCards myDeck = new DeckOfCards();
		
		System.out.println(myDeck);
		myDeck.shuffle();
		System.out.println(myDeck);

	}

}
