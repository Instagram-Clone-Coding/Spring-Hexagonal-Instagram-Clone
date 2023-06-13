package clone.instagram.error.exception;

import static clone.instagram.error.ErrorCode.*;

public class CommandNotSupportedException extends InternalLogException {

	public CommandNotSupportedException() {
		super(COMMAND_NOT_SUPPORTED);
	}

}
