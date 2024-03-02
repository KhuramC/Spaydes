package cardDeck;

import java.util.ArrayList;

public class Discard {

	public Discard() {
		discard = new ArrayList<Card>();
		
	}
	
	
	public void addCard(Card c) {
		this.discard.add(c);
	}
	
	public Card removeCard() {
		return this.discard.get(0);
	}
	
	
	private ArrayList<Card> discard;


}
