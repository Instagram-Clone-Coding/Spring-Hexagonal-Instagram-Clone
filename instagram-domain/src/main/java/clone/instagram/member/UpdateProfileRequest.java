package clone.instagram.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateProfileRequest {

	private String username;
	private String password;
	private String name;
	private String website;
	private String introduce;
	private String email;
	private String phone;
	private Gender gender;

}
