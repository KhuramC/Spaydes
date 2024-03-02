package cardDeck;
import java.util.ArrayList;
import java.util.Comparator;

import cardDeck.Exceptions.EmptyDeckException;
import cardDeck.Exceptions.FullHandException;

import java.util.Collections;


/**
 * A class for producing a Hand of Cards, tailored for the game of Spades. Only allows for
 * a maximum of 13 Cards in each Hand.
 * @author Khuram Choudhry
 *
 */
public class Hand {
	
	/**
	 * Constructs an empty Hand.
	 */
	public Hand() 
	{
		hand = new ArrayList<Card>();
	}
	
	/**
	 * Returns the current size of the Hand.
	 * @return an integer containing the size of the Hand.
	 */
	public int getHandSize() 
	{
		return this.hand.size();		
	}
	
	/**
	 * Adds a card to the Hand.
	 * @param c : The Card to be added to the Hand.
	 * @throws FullHandException if the Hand already has at least 13 cards(full for Spades).
	 */
	public void addCardtoHand(Card c) throws FullHandException 
	{
		if(this.hand.size() >= 13) {
			throw new FullHandException("Error: Hand is already full.");
		}else {
			this.hand.add(c);
		}
		
	}
	
	/**
	 * Removes a Card from the Hand to be played.
	 * @param index : The index of the desired Card.
	 * @return The Card that was removed from the Hand.
	 */
	public Card playCard(int index) 
	{
		Card c = this.hand.remove(index);
		return c;
	}
	
	/**
	 * Sorts the Hand by Suit, and within each Suit by Rank.
	 */
	public void sortHand() 
	{
		//While a comparator is usually just an interface, this works because we implement the compare function here
		//so the requirement has been satisfied//
		Comparator<Card> comp = new Comparator<Card>() {
			
			@Override
			public int compare(Card c1, Card c2) {
				//if the two Cards are of different Suits
				if(!c1.getSuit().equals(c2.getSuit())) {
					//Compare them based off Suits then//
					return c1.getSuit().compareTo(c2.getSuit());
				}else {
					//Else(same Suits) compare them based off Ranks instead//
					return c1.getRank().compareTo(c2.getRank());
				}
			}
			
		};
		Collections.sort(this.hand, comp);
	}
	

	/**
	 * Returns the String representation of the Hand. Ex: [King of Spades, Hand of Spades].
	 */
	public String toString()
	{
		String s = "[";
		for(int i = 0; i < this.getHandSize(); i++) {
			s+= this.hand.get(i);
			if(i!= this.getHandSize() - 1) {
				s += ", ";
			}
			if(i % 5 == 0 && i!= 0) {
				s += "\n";
			}
		}
		s+= "]";
		return s;
	}
	
	public static void main (String[] args) {
		Deck d = new Deck();
		d.shuffle();
		Hand h = new Hand();
		for(int i = 0; i < 14;i++) {
			try {
				Card c = d.dealCard();
				try {
					h.addCardtoHand(c);
				}catch (FullHandException e) {
					//if card is mistakenly taken from the deck, it should go back to the bottom.
					d.addCardToDeck(d.getDeckSize()-1, c);
					e.printStackTrace();
					break;
				}	
			}catch (EmptyDeckException e) {
				e.printStackTrace();
				break;
			}
		}
		System.out.println("The size of the deck after dealing is " + d.getDeckSize() + 
				" and is:\n" + d);
		System.out.println("The size of the hand is " + h.getHandSize() + " and is:\n" + h);
		h.sortHand();
		System.out.println("The hand after sorting is:\n" + h);
	} 
	
	private ArrayList<Card> hand;
}
