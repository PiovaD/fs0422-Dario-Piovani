package jpacrudrest.exceptions;

public class PageException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public PageException(String message) {
		super("Page Exception " + message);
	}
	


}
