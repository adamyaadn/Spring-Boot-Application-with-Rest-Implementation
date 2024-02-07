package training.trg.rest.exceptions;

public class DuplicateDataException extends RuntimeException {
	public String getMessage() {
		return "Employee already exists.";
	}
}
