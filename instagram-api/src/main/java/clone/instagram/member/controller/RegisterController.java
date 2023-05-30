package clone.instagram.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import clone.instagram.member.Member;
import clone.instagram.member.port.in.RegisterUseCase;
import clone.instagram.member.request.RegisterRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@Api(tags = "멤버 인증 API")
@Validated
@RestController
@RequiredArgsConstructor
public class RegisterController {

	private final RegisterUseCase registerUseCase;

	@ApiOperation(value = "회원가입")
	@ApiResponses({
		@ApiResponse(code = 200, message = "M001 - 회원가입에 성공하였습니다.\n"
			+ "M013 - 이메일 인증을 완료할 수 없습니다."),
		@ApiResponse(code = 400, message = "G003 - 유효하지 않은 입력입니다.\n"
			+ "G004 - 입력 타입이 유효하지 않습니다.\n"
			+ "M002 - 이미 존재하는 사용자 이름입니다.\n"
			+ "M007 - 인증 이메일 전송을 먼저 해야합니다.")
	})
	@PostMapping(value = "/accounts")
	public ResponseEntity<Boolean> register(@RequestBody RegisterRequest registerRequest) {
		// TODO 반환 타입 정의 후 수정
		final RegisterUseCase.Command command = mapRequestToCommand(registerRequest);

		return ResponseEntity.ok(toResponseEntity(registerUseCase.invoke(command)));
	}

	private RegisterUseCase.Command mapRequestToCommand(RegisterRequest registerRequest) {
		return new RegisterUseCase.RegisterInfoCommand(
			Member.ofUnregistered(
				registerRequest.getUsername(),
				registerRequest.getPassword(),
				registerRequest.getName(),
				registerRequest.getEmail()
			)
		);
	}

	private boolean toResponseEntity(boolean isRegistered) {
		return isRegistered;
		// TODO ResultEntity 적용
		// if (isRegistered) {
		// 	return ResponseEntity.ok(ResultResponse.of(REGISTER_SUCCESS, true));
		// } else {
		// 	return ResponseEntity.ok(ResultResponse.of(CONFIRM_EMAIL_FAIL, false));
		// }
	}

}
