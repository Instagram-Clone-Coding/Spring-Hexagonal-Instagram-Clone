package clone.instagram.error.exception.member;

import static clone.instagram.error.ErrorCode.*;

import clone.instagram.error.exception.BusinessException;

public class MemberNotFoundException extends BusinessException {

	public MemberNotFoundException() {
		super(MEMBER_NOT_FOUND);
	}

}
