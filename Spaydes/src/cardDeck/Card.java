package cardDeck;

/**
 * A class for producing regular Cards.
 * @author Khuram Choudhry
 */
public class Card {
	
	/**
	 * Constructs a Card with the given suit and rank.
	 * @param aSuit : the suit of the card constructed.
	 * @param aRank : the rank of the card constructed.
	 */
	public Card(Suits aSuit,Ranks aRank) 
	{
		suit = aSuit;
		rank = aRank;
	}
	
	/**
	 * Returns the suit of the Card.
	 * @return the suit of the Card.
	 */
	public Suits getSuit() 
	{
		return this.suit;
	}
	
	/**
	 * Returns the rank of the Card.
	 * @return the rank of the Card.
	 */
	public Ranks getRank() 
	{
		return this.rank;
	}
	
	/**
	 * Returns the String representation of the Card(Like "Ace of Spades").
	 */
	public String toString() 
	{
		String s = this.getRank() + " of " + this.getSuit();
		return s;
	}
	
	private Suits suit;
	private Ranks rank;
}
