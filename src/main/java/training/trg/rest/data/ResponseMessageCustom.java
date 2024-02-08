package training.trg.rest.data;

import java.time.LocalDateTime;

public class ResponseMessageCustom {
	private String message;
	private LocalDateTime time;
	public ResponseMessageCustom() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public ResponseMessageCustom(String message, LocalDateTime time) {
		super();
		this.message = message;
		this.time = time;
	}
}
