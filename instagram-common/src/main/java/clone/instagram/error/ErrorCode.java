package clone.instagram.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

	// Global
	INTERNAL_SERVER_ERROR(500, "G001", "내부 서버 오류입니다."),
	METHOD_NOT_ALLOWED(405, "G002", "허용되지 않은 HTTP method 입니다."),
	INPUT_VALUE_INVALID(400, "G003", "유효하지 않은 입력입니다."),
	INPUT_TYPE_INVALID(400, "G004", "입력 타입이 유효하지 않습니다."),
	HTTP_MESSAGE_NOT_READABLE(400, "G005", "request message body 가 없거나, 값 타입이 올바르지 않습니다."),
	HTTP_HEADER_INVALID(400, "G006", "request header 가 유효하지 않습니다."),
	IMAGE_TYPE_NOT_SUPPORTED(400, "G007", "지원하지 않는 이미지 타입입니다."),
	FILE_CONVERT_FAIL(500, "G008", "변환할 수 없는 파일입니다."),
	ENTITY_TYPE_INVALID(500, "G009", "올바르지 않은 entity type 입니다."),

	// Internal
	FILTER_MUST_RESPOND(500, "I001", "필터에서 처리해야 할 요청이 컨트롤러에 접근하였습니다."),
	COMMAND_NOT_SUPPORTED(500, "I002", "UseCase 에서 지원하지 않는 Command 입니다."),

	// Member
	MEMBER_NOT_FOUND(400, "M001", "존재 하지 않는 유저입니다."),
	USERNAME_ALREADY_EXIST(400, "M002", "이미 존재하는 사용자 이름입니다.");

	private final int status;
	private final String code;
	private final String message;

}
