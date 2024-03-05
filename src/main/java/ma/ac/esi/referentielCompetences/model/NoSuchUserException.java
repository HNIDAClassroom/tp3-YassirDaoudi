package ma.ac.esi.referentielCompetences.model;

public class NoSuchUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2343216503161255422L;

	public NoSuchUserException() {
		super("No Such User In The Database");
		// TODO Auto-generated constructor stub
	}

	public NoSuchUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NoSuchUserException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NoSuchUserException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NoSuchUserException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
