package clone.instagram.jpa.entity.member;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import clone.instagram.global.ImageType;
import clone.instagram.jpa.entity.global.ImageEntity;
import clone.instagram.member.Gender;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "members")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberEntity {

	@Id
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Setter
	@Column(name = "member_username", nullable = false, length = 20, unique = true)
	private String username;

	@Setter
	@Column(name = "member_password", nullable = false)
	private String password;

	@Setter
	@Column(name = "member_name", nullable = false, length = 20)
	private String name;

	@Setter
	@Column(name = "member_email")
	private String email;

	@Setter
	@Column(name = "member_website")
	private String website;

	@Lob
	@Setter
	@Column(name = "member_introduce")
	private String introduce;

	@Setter
	@Column(name = "member_phone")
	private String phone;

	@Setter
	@Column(name = "member_gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Setter
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "imageUrl", column = @Column(name = "member_image_url")),
		@AttributeOverride(name = "imageType", column = @Column(name = "member_image_type")),
		@AttributeOverride(name = "imageName", column = @Column(name = "member_image_name")),
		@AttributeOverride(name = "imageUUID", column = @Column(name = "member_image_uuid"))
	})
	private ImageEntity image;

	public MemberEntity(String username, String password, String name, String email) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.gender = Gender.PRIVATE;
		this.image = new ImageEntity(
			"base",
			ImageType.PNG,
			"https://instagram-s3-dev.s3.ap-northeast-2.amazonaws.com/member/base-UUID_base.PNG.png",
			"base-UUID"
		);
	}

}
