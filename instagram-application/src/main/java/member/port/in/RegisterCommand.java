package member.port.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import member.Member;

@Getter
@AllArgsConstructor
public class RegisterCommand {

	private final Member member;

}
