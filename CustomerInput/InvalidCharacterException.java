public class InvalidCharacterException extends Exception {
	
	public InvalidCharacterException() {
		super("Invalid ");
	}
	public InvalidCharacterException(String message) {
		super(message);
	}
}

