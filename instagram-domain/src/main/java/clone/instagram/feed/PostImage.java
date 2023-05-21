package clone.instagram.feed;

import clone.instagram.global.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostImage {

	private Long id;
	private Post post;
	private Image image;
	private String altText;

}
