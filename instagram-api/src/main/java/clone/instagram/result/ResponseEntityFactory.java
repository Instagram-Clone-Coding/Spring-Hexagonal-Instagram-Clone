package clone.instagram.result;

import org.springframework.http.ResponseEntity;

import clone.instagram.result.ResultCode;
import clone.instagram.result.ResultResponse;

public class ResponseEntityFactory {

	public static ResponseEntity<ResultResponse> of(ResultCode resultCode) {
		return new ResponseEntity<>(ResultResponse.of(resultCode), resultCode.getStatus());
	}

	public static ResponseEntity<ResultResponse> of(ResultCode resultCode, Object data) {
		return new ResponseEntity<>(ResultResponse.of(resultCode, data), resultCode.getStatus());
	}

}
