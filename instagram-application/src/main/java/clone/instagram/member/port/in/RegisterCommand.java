package clone.instagram.member.port.in;

import clone.instagram.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterCommand {

	private final Member member;

}
