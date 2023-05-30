package clone.instagram.member.port.in;

import clone.instagram.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

public interface RegisterUseCase {

	boolean invoke(Command command);

	interface Command {

	}

	@Getter
	@AllArgsConstructor
	class AccountInfoCommand implements Command {

		private final Member member;

	}

}
