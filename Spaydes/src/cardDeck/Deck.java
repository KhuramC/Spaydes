package cardDeck;
import java.util.ArrayList;
import java.util.Collections;
import cardDeck.Exceptions.EmptyDeckException;


/**
 * A class for producing a Deck of Cards, tailored for the game Spades.
 * @author Khuram Choudhry
 *
 */
public class Deck {
	
	/**
	 * Constructs a typical Deck of 52 Cards. Index 0 is considered the top of the deck.
	 */
	public Deck() 
	{
		deck = new ArrayList<Card>();
		for(Suits suit: Suits.values()) {
			for(Ranks rank: Ranks.values()) {
				Card c = new Card(suit,rank);
				deck.add(c);
			}
		}
	}
	
	/**
	 * Returns the current size of the Deck.
	 * @return an integer containing the size.
	 */
	public int getDeckSize() 
	{
		return this.deck.size();
	}
	
	/**
	 * Shuffles the Deck.
	 */
	public void shuffle() 
	{
		Collections.shuffle(this.deck);
	}
	
	/**
	 * Removes a Card from the top of the Deck. 
	 * @return The card at index 0, defined to be the top of the Deck.
	 * @throws EmptyDeckException if the Deck is empty or has size 0.
	 */
	public Card dealCard() throws EmptyDeckException 
	{
		if(this.deck.isEmpty() == true) {
			throw new EmptyDeckException("Error: No cards in deck to remove.");
		}else {
			Card c = this.deck.remove(0);
			return c;	
		}
		
	}
	
	/**
	 * Adds the Card to the specified index of the Deck.
	 * @param index : where in the Deck the Card should be inserted.
	 * @param c : The Card to be added to the Deck.
	 */
	public void addCardToDeck(int index, Card c) 
	{
		this.deck.add(index, c);
	}
	
	/**
	 * Returns whether the Deck is empty or not.
	 * @return boolean value if the Deck is empty or not.
	 */
	public boolean isEmpty() 
	{
		return(this.deck.isEmpty());
	}
	
	
	/**
	 * Returns the String representation of the Deck. Ex: {Ace of Spades, Jack of Spades}
	 */
	public String toString() {
		String s = "{";
		for(int i = 0; i < this.getDeckSize();i++) {
			s += this.deck.get(i);
			if(i!= this.getDeckSize()- 1) {
				s += ", ";
			}
			if(i % 5 == 0 && i!= 0) {
				s += "\n";
			}
		}
		s +="}";
		return s;
	}
	
	/*public static void main (String[] args) 
	{
		Deck d = new Deck();
		System.out.println("The deck is currently:\n" + d);
		d.shuffle();
		System.out.println("The deck is now:\n" + d);
		for(int i = 0; i < 60; i++) {
			try {
				Card c = d.dealCard();
				System.out.print(c + " was dealt out.\n");
			} catch (EmptyDeckException e) {
				e.printStackTrace();
				break;01		
			}
		} 		
	} */
	
	private ArrayList<Card> deck;
}
