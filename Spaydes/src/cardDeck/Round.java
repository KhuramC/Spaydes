package cardDeck;

import java.util.ArrayList;

public class Round {

	
	//A round should include the betting phase of the players, the dealing of Cards from the
	//deck, which should be the same throughout rounds(so make a deck in the constructor).
	//Then the actual round with tricks, and the gameplay loop within the round occurs.
	public Round(Player P1, Player P2, Player P3, Player P4, Deck Deck) {
		// TODO Auto-generated constructor stub
		players = new ArrayList<Player>();
		deck = Deck;
	}
	
	//
	public void playRound() {
		System.out.println("Current leaderboards:");
		for(Player player: this.players) {
			System.out.println(player);
		}
		
		
		
	}
	
	public static void main (String[] args) {
		
		
	}
	private ArrayList<Player> players;
	private Deck deck;
}
//