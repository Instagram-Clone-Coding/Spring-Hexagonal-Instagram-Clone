package clone.instagram.member;

import clone.instagram.global.ImageType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseMemberImageProperty {

	private final String baseImageUrl;

	private final ImageType baseImageType;

	private final String baseImageName;

	private final String baseImageUUID;

}