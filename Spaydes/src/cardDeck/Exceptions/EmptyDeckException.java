package cardDeck.Exceptions;

public class EmptyDeckException extends Exception {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6764355954767437025L;

	public EmptyDeckException(String errorMessage) {
		super(errorMessage);
	}

}
