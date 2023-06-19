package clone.instagram.error.exception;

import clone.instagram.error.ErrorCode;
import lombok.Getter;

@Getter
public class InternalLogException extends RuntimeException{

	private final ErrorCode errorCode;

	public InternalLogException(String message, ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public InternalLogException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}

}
