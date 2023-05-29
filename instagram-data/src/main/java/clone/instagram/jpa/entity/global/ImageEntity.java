package clone.instagram.jpa.entity.global;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.beans.factory.annotation.Value;

import clone.instagram.global.ImageType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ImageEntity {

	@Value("${image.base.url}")
	private static String BASE_IMAGE_URL;

	@Value("${image.base.name}")
	private static String BASE_IMAGE_NAME;

	@Value("${image.base.type}")
	private static String BASE_IMAGE_TYPE;

	@Value("${image.base.uuid}")
	private static String BASE_IMAGE_UUID;

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

	public static ImageEntity createBaseImageEntity() {
		return new ImageEntity(
			BASE_IMAGE_URL,
			ImageType.valueOf(BASE_IMAGE_TYPE),
			BASE_IMAGE_NAME,
			BASE_IMAGE_UUID
		);
	}

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
