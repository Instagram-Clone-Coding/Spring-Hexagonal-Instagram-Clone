package clone.instagram.jpa.mapper;

import org.springframework.stereotype.Component;

import clone.instagram.global.Image;
import clone.instagram.jpa.entity.global.ImageEntity;

@Component
public class ImageMapper {

	public Image mapToDomainModel(ImageEntity image) {
		return new Image(
			image.getImageUrl(),
			image.getImageType(),
			image.getImageName(),
			image.getImageUUID()
		);
	}

	public ImageEntity mapToJpaEntity(Image image) {
		return new ImageEntity(
			image.getImageUrl(),
			image.getImageType(),
			image.getImageName(),
			image.getImageUUID()
		);
	}

}
