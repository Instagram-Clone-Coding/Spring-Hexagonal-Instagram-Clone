package clone.instagram.feed;

import java.time.LocalDateTime;

import clone.instagram.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Post {

	private Long id;
	private Member member;
	private String content;
	private LocalDateTime uploadDate;
	private boolean commentFlag;
	private boolean likeFlag;

}
