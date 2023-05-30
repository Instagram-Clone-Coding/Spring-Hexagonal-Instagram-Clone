package clone.instagram.member.service;

import org.springframework.stereotype.Service;

import clone.instagram.member.Member;
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
		if(!command.getClass().isAssignableFrom(RegisterInfoCommand.class)){
			throw new RuntimeException("Command inappropriate");
		}
		final Member member = ((RegisterInfoCommand)command).getMember();
		if (loadMemberPort.existsMemberByUsername(member.getUsername())) {
			// TODO Exception 공동 처리 작업 후 수정
			throw new RuntimeException("Username already exists!");
		}
		// TODO email code check

		saveMemberPort.saveMember(member);

		// TODO SearchMember 추가
		return true;
	}

}
