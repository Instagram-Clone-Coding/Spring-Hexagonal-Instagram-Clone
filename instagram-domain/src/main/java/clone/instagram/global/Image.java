package clone.instagram.global;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Image {

	private String imageUrl;
	private ImageType imageType;
	private String imageName;
	private String imageUUID;

	@Override
	public int hashCode() {
		return Objects.hash(this.imageUUID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Image image = (Image)obj;
		return Objects.equals(this.imageUUID, image.getImageUUID());
	}

}
