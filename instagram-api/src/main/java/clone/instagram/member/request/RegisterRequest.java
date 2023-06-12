package clone.instagram.member.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegisterRequest {

	private String username;
	private String password;
	private String name;
	private String email;

}
