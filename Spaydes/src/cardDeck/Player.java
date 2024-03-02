package cardDeck;
//Needs to hold points, sandbags, bets and hands of each individual player
public class Player {

	
	//Sset constructor to require name
	public Player() {
		points = 0;
		sandbags = 0;
		bet = 0;
		tricks = 0;
		h = new Hand();
	}
	
	
	
	
	/**
	 * Returns the amount of points the Player currently has.
	 * @return integer 'points' variable.
	 */
	public int getPoints() {
		return this.points;
	}
	
	/**
	 * Adds or subtracts specified value to points. Done after each round's completion.
	 * @param addition : the amount to be added/subtracted.
	 */
	public void changePoints(int addition) {
		this.points += addition;
	}
	
	/**
	 * Sets points back to 0. Only used if a game has finished
	 */
	public void resetPoints() {
		this.points = 0;
	}
	
	/**
	 * Returns the amount of Sandbags that the Player currently has.
	 * @return integer value sandbags.
	 */
	public int getSandbags() {
		return this.sandbags;
	}
	
	/**
	 * Adds or subtracts the specified value to sandbags. Done after each round's completion.
	 * @param addition : amount to be added or subtracted.
	 */
	public void changeSandbags(int addition) {
		this.sandbags += addition;

	}
	
	/**
	 * Resets sandbags back to zero. Typically done at the end of a game.
	 */
	public void resetSandbags() {
		this.sandbags = 0;
	}
	
	/**
	 * Checks if the sandbags is greater than 5. For every 5 sandbags, 50 points are subtracted
	 * whilst deleting 5 sandbags.
	 */
	public void checkSandbags() {
		if(this.getSandbags() >= 5) {
			this.changePoints(-50);
			this.changeSandbags(-5);
			this.checkSandbags();
		}
	}
	
	/**
	 * Retrieves the bet that the player set.
	 * @return the bet value.
	 */
	public int getBet() {
		return this.bet;
	}
	
	/**
	 * Sets the bet value to whatever the player wants to set it as. Done at the start of every round.
	 * @param bet : the value the bet will take.
	 */
	public void setBet(int bet) {
		this.bet = bet;
	}
	
	/**
	 * Retrieves the tricks that the player has in the current round.
	 * @return
	 */
	public int getTricks() {
		return this.tricks;
	}
	
	/**
	 * Increment the tricks value. Done at the end of a trick if the player won.
	 */
	public void incTricks() {
		this.tricks++;
	}
	
	/**
	 * Sets the tricks value back to 0. Done at the end of every round.
	 */
	public void resetTricks() {
		this.tricks = 0;
	}

	



	/**
	 * Returns the player's hand.
	 * @return Hand object.
	 */
	public Hand getHand() {
		return this.h;
	}


	/**
	 * Sets hand to a full hand(presumably a full hand of Cards).
	 * @param h : the(presumably) full hand. 
	 */
	public void setHand(Hand h) {
		this.h = h;
	}



	public void setName(String aName) {
		this.name = aName;
	}
	public String getName() {
		return this.name;
	}
	
	public String toString() {
		String s = "";
		s += this.getName();
		s+= " has " + this.getPoints(); //+ " and will";
		return s;
		
	}
	


	//total amount of points//
	private int points;
	//total amount of sandbags//
	private int sandbags;
	//bet for the round//
	private int bet;
	//tricks made for the round//
	private int tricks;
	//hand throughout the round//
	private Hand h;
	
	private String name;

}
