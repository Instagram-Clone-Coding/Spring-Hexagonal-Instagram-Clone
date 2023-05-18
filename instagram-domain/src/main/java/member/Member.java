package member;

import global.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Member {

	private Long id;
	private String username;
	private String password;
	private String name;
	private String website;
	private String introduce;
	private String email;
	private String phone;
	private Gender gender;
	private Image image;

	public void updateProfile(UpdateProfileRequest request) {
		this.username = request.getUsername();
		this.password = request.getPassword();
		this.name = request.getName();
		this.website = request.getWebsite();
		this.introduce = request.getIntroduce();
		this.email = request.getEmail();
		this.phone = request.getPhone();
		this.gender = request.getGender();
	}

	public void updateImage(Image image) {
		this.image = image;
	}

}
