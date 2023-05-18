package feed;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import member.Member;

@Getter
@AllArgsConstructor
public class Comment {

	private Long id;
	private Comment parent;
	private Member member;
	private Post post;
	private String content;
	private LocalDateTime uploadDate;

}
