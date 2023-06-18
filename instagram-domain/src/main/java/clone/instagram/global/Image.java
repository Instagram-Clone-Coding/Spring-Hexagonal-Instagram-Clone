package clone.instagram.global;

import java.util.Objects;

import clone.instagram.member.BaseMemberImageProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Image {

	private String imageUrl;
	private ImageType imageType;
	private String imageName;
	private String imageUUID;

	public static Image of(BaseMemberImageProperty baseMemberImageProperty) {
		return new Image(
			baseMemberImageProperty.getBaseImageUrl(),
			baseMemberImageProperty.getBaseImageType(),
			baseMemberImageProperty.getBaseImageName(),
			baseMemberImageProperty.getBaseImageUUID()
		);
	}

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

		final Image image = (Image)obj;
		return Objects.equals(this.imageUUID, image.getImageUUID());
	}

}
