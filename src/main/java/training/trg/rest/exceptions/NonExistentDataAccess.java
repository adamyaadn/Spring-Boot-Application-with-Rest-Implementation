package training.trg.rest.exceptions;

public class NonExistentDataAccess extends RuntimeException {
	public String getMessage() {
		return "Employee doesn't exist.";
	}
}	
