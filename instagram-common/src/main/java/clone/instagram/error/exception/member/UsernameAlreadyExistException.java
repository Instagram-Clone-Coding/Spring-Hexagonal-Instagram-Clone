package clone.instagram.error.exception.member;

import static clone.instagram.error.ErrorCode.*;

import clone.instagram.error.exception.BusinessException;

public class UsernameAlreadyExistException extends BusinessException {

	public UsernameAlreadyExistException() {
		super(USERNAME_ALREADY_EXIST);
	}

}
