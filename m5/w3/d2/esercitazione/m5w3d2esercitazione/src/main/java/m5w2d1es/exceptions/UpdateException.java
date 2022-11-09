package m5w2d1es.exceptions;


public class UpdateException extends Exception {

	/**
	 * Non credo mi servira' mai
	 */
	private static final long serialVersionUID = 1L;

	public UpdateException() {
		super("Something weent wrong during the update");
	}
}
