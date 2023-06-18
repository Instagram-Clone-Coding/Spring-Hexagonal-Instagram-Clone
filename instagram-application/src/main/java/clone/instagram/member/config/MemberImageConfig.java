package clone.instagram.member.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import clone.instagram.global.ImageType;
import clone.instagram.member.BaseMemberImageProperty;

@Configuration
public class MemberImageConfig {

	@Bean
	public BaseMemberImageProperty baseMemberImageProperty(
		@Value("${image.base.url}") String baseImageUrl,
		@Value("${image.base.name}") String baseImageName,
		@Value("${image.base.type}") String baseImageType,
		@Value("${image.base.uuid}") String baseImageUUID) {
		return new BaseMemberImageProperty(baseImageUrl, ImageType.valueOf(baseImageType),
			baseImageName, baseImageUUID);

	}

}
