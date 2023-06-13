package clone.instagram.member.service;

import org.springframework.stereotype.Service;

import clone.instagram.error.exception.CommandNotSupportedException;
import clone.instagram.member.Member;
import clone.instagram.error.exception.member.UsernameAlreadyExistException;
import clone.instagram.member.port.in.RegisterUseCase;
import clone.instagram.member.port.out.LoadMemberByUsernamePort;
import clone.instagram.member.port.out.SaveMemberPort;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterService implements RegisterUseCase {

	private final LoadMemberByUsernamePort loadMemberPort;
	private final SaveMemberPort saveMemberPort;

	@Override
	public boolean invoke(RegisterUseCase.Command command) {
		if (!command.getClass().isAssignableFrom(RegisterUseCase.Command.ToRegisterInfo.class)) {
			throw new CommandNotSupportedException();
		}

		final Member member = ((RegisterUseCase.Command.ToRegisterInfo)command).convertToMember();
		if (loadMemberPort.existsMemberByUsername(member.getUsername())) {
			throw new UsernameAlreadyExistException();
		}
		// TODO email code check

		saveMemberPort.saveMember(member);

		// TODO SearchMember 추가
		return true;
	}

}
