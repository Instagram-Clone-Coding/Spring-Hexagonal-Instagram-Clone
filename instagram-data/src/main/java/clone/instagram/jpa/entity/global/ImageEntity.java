package clone.instagram.jpa.entity.global;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import clone.instagram.global.ImageType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ImageEntity {

	@Setter
	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "image_type")
	@Enumerated(EnumType.STRING)
	private ImageType imageType;

	@Column(name = "image_name")
	private String imageName;

	@Column(name = "image_uuid")
	private String imageUUID;

	@Override
	public int hashCode() {
		return Objects.hash(getImageUUID());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		final ImageEntity imageEntity = (ImageEntity)obj;
		return Objects.equals(getImageUUID(), imageEntity.getImageUUID());
	}

}
