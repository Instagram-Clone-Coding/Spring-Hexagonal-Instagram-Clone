package clone.instagram.result;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {

	// Member
	REGISTER_SUCCESS(201, "M001", "회원가입에 성공하였습니다."),
	CONFIRM_EMAIL_FAIL(200, "M002", "이메일 인증을 완료할 수 없습니다.");

	private final int status;
	private final String code;
	private final String message;

}
