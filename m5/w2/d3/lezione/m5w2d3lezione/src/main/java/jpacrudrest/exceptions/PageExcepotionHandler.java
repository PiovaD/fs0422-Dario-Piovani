package jpacrudrest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class PageExcepotionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(PageException.class)
	protected ResponseEntity<Object> handlePageExc(PageException exc){
		PageError pe = new PageError(exc.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(pe, pe.getStatus());
	}
	
	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	protected ResponseEntity<Object> handleAIIOBExc(ArrayIndexOutOfBoundsException exc){
		PageError pe = new PageError(exc.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(pe, pe.getStatus());
	}
}
