package clone.instagram.member.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegisterRequest {

	@ApiModelProperty(value = "유저네임", example = "dlwlrma", required = true)
	@NotBlank(message = "username을 입력해주세요")
	@Size(min = 4, max = 12, message = "사용자 이름은 4문자 이상 12문자 이하여야 합니다")
	@Pattern(regexp = "^[0-9a-zA-Z]+$", message = "username엔 대소문자, 숫자만 사용할 수 있습니다.")
	private String username;

	@ApiModelProperty(value = "이름", example = "이지금", required = true)
	@NotBlank(message = "이름을 입력해주세요")
	@Size(min = 2, max = 12, message = "이름은 2문자 이상 12문자 이하여야 합니다")
	private String password;

	@ApiModelProperty(value = "비밀번호", example = "a12341234", required = true)
	@NotBlank(message = "비밀번호를 입력해주세요")
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "비밀번호는 8자 이상, 최소 하나의 문자와 숫자가 필요합니다")
	@Size(max = 20, message = "비밀번호는 20문자 이하여야 합니다")
	private String name;

	@ApiModelProperty(value = "이메일", example = "aaa@gmail.com", required = true)
	@NotBlank(message = "이메일을 입력해주세요")
	@Email(message = "이메일의 형식이 맞지 않습니다")
	private String email;

}
