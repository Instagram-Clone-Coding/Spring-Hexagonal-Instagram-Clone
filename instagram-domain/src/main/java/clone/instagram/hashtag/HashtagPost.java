package clone.instagram.hashtag;

import clone.instagram.feed.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HashtagPost {

	private Long id;
	private String name;
	private Long count;
	private Post post;

}
