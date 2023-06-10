package clone.instagram.member.port.in;

import clone.instagram.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

public interface RegisterUseCase {

	boolean invoke(Command command);

	interface Command {

		@Getter
		@AllArgsConstructor
		class ToRegisterInfo implements Command {

			private final String username;
			private final String password;
			private final String name;
			private final String email;

			public Member convertToMember() {
				return Member.ofUnregistered(username, password, name, email);
			}

		}

	}

}
