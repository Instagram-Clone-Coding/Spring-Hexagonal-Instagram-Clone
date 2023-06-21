package clone.instagram.member.controller;

import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import clone.instagram.member.BaseMemberImageProperty;
import clone.instagram.member.port.in.RegisterUseCase;

@WebMvcTest(controllers = RegisterController.class)
public class RegisterControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RegisterUseCase registerUseCase;

	@MockBean
	private BaseMemberImageProperty baseMemberImageProperty;

	@Test
	void validArguments_Invoke() throws Exception {
		// given
		final String request = "{"
			+ "\"username\":\"agent\", \"name\":\"name\", \"password\":\"password\", \"email\":\"agent@email.com\""
			+ "}";
		given(registerUseCase.invoke(any())).willReturn(true);

		// when
		mockMvc.perform(MockMvcRequestBuilders.post("/accounts")
				.content(request)
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isCreated());

		// then
		then(registerUseCase).should().invoke(any());
	}

}
