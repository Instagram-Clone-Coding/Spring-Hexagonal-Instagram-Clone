package feed;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import member.Member;

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
