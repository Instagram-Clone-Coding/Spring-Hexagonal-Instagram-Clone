package clone.instagram.member;

import clone.instagram.global.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Member {

	private Long id;
	private String username;
	private String password;
	private String name;
	private String email;
	private String website;
	private String introduce;
	private String phone;
	private Gender gender;
	private Image image;

	public static Member ofUnregistered(String username, String password, String name, String email, Image image) {
		return new Member(
			username,
			password,
			name,
			email,
			image
		);
	}

	private Member(String username, String password, String name, String email, Image image) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.image = image;
	}

	public void updateProfile(UpdateProfileRequest request) {
		this.username = request.getUsername();
		this.password = request.getPassword();
		this.name = request.getName();
		this.email = request.getEmail();
		this.website = request.getWebsite();
		this.introduce = request.getIntroduce();
		this.phone = request.getPhone();
		this.gender = request.getGender();
	}

	public void updateImage(Image image) {
		this.image = image;
	}

}
