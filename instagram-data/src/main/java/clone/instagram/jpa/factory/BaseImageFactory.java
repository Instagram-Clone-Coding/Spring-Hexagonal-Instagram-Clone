package clone.instagram.jpa.factory;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import clone.instagram.global.ImageType;
import clone.instagram.jpa.entity.global.ImageEntity;

@Component
public class BaseImageFactory {

	public static String BASE_IMAGE_URL;

	public static String BASE_IMAGE_NAME;

	public static String BASE_IMAGE_TYPE;

	public static String BASE_IMAGE_UUID;

	@Value("${image.base.url}")
	private String baseImageUrl;

	@Value("${image.base.name}")
	private String baseImageName;

	@Value("${image.base.type}")
	private String baseImageType;

	@Value("${image.base.uuid}")
	private String baseImageUUID;

	@PostConstruct
	private void setStaticBaseImageValues() {
		BASE_IMAGE_URL = this.baseImageUrl;
		BASE_IMAGE_NAME = this.baseImageName;
		BASE_IMAGE_TYPE = this.baseImageType;
		BASE_IMAGE_UUID = this.baseImageUUID;
	}

	public static ImageEntity createBaseImageEntity() {
		return new ImageEntity(
			BASE_IMAGE_URL,
			ImageType.valueOf(BASE_IMAGE_TYPE),
			BASE_IMAGE_NAME,
			BASE_IMAGE_UUID
		);
	}

}
