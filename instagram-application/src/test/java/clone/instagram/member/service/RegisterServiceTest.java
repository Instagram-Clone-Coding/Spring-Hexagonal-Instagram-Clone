package clone.instagram.member.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import clone.instagram.error.exception.member.UsernameAlreadyExistException;
import clone.instagram.member.BaseMemberImageProperty;
import clone.instagram.member.port.in.RegisterUseCase;
import clone.instagram.member.port.out.LoadMemberByUsernamePort;
import clone.instagram.member.port.out.SaveMemberPort;

@ExtendWith(MockitoExtension.class)
public class RegisterServiceTest {

	@InjectMocks
	private RegisterService registerService;

	@Mock
	private LoadMemberByUsernamePort loadMemberPort;

	@Mock
	private SaveMemberPort saveMemberPort;

	@Mock
	private BaseMemberImageProperty baseMemberImageProperty;

	@Test
	void validArguments_CallSaveMember() {
		// given
		final String username = "username";
		final RegisterUseCase.Command.ToRegisterInfo command
			= new RegisterUseCase.Command.ToRegisterInfo(
			username, "password", "name", "email", baseMemberImageProperty
		);

		// when
		final boolean result = registerService.invoke(command);

		// then
		then(saveMemberPort).should().saveMember(any());
		assertThat(result).isTrue();
	}

	@Test
	void usernameExists_ThrowException() {
		// given
		final String username = "username";
		final RegisterUseCase.Command.ToRegisterInfo command
			= new RegisterUseCase.Command.ToRegisterInfo(
			username, "password", "name", "email", baseMemberImageProperty
		);
		given(loadMemberPort.existsMemberByUsername(username)).willReturn(true);

		// when
		final ThrowingCallable executable = () -> registerService.invoke(command);

		// then
		assertThatThrownBy(executable).isInstanceOf(UsernameAlreadyExistException.class);
	}

}
