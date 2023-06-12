package clone.instagram.jpa.entity.member;

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

import clone.instagram.jpa.entity.global.ImageEntity;
import clone.instagram.jpa.factory.BaseImageFactory;
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
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Setter
	@Column(name = "username", nullable = false, length = 20, unique = true)
	private String username;

	@Setter
	@Column(name = "password", nullable = false)
	private String password;

	@Setter
	@Column(name = "name", nullable = false, length = 20)
	private String name;

	@Setter
	@Column(name = "email")
	private String email;

	@Setter
	@Column(name = "website")
	private String website;

	@Lob
	@Setter
	@Column(name = "introduce")
	private String introduce;

	@Setter
	@Column(name = "phone")
	private String phone;

	@Setter
	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Setter
	@Embedded
	private ImageEntity image;

	public MemberEntity(String username, String password, String name, String email) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.gender = Gender.PRIVATE;
		this.image = BaseImageFactory.createBaseImageEntity();
	}

}
