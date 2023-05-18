package feed;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostTag {

	private Long id;
	private PostImage postImage;
	private String tag;

}

