package clone.instagram.result;

import org.springframework.http.HttpStatus;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
@ApiModel(description = "결과 응답 데이터 모델")
public class ResultResponse {

	@ApiModelProperty(value = "Http 상태 코드")
	private final HttpStatus status;

	@ApiModelProperty(value = "Business 상태 코드")
	private final String code;

	@ApiModelProperty(value = "응답 메세지")
	private final String message;

	@ApiModelProperty(value = "응답 데이터")
	private final Object data;

	private ResultResponse(ResultCode resultCode, Object data) {
		this.status = resultCode.getStatus();
		this.code = resultCode.getCode();
		this.message = resultCode.getMessage();
		this.data = data;
	}

	public static ResultResponse of(ResultCode resultCode, Object data) {
		return new ResultResponse(resultCode, data);
	}

	public static ResultResponse of(ResultCode resultCode) {
		return new ResultResponse(resultCode, "");
	}

}
