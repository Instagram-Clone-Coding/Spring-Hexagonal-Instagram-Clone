package clone.instagram.member.out.adapter;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import clone.instagram.error.exception.member.MemberNotFoundException;
import clone.instagram.jpa.mapper.ImageMapper;
import clone.instagram.jpa.mapper.MemberMapper;
import clone.instagram.member.Member;

@DataJpaTest
@Import({ImageMapper.class, MemberMapper.class, MemberPersistentAdapter.class})
public class MemberPersistentAdapterTest {

	@Autowired
	private MemberPersistentAdapter memberPersistentAdapter;

	@Nested
	@DisplayName("loadMemberByUsername()")
	class LoadMemberByUsername {

		@Test
		@Sql("classpath:BaseMember.sql")
		void validArguments_ReturnMember() {
			// given

			// when
			final Member member = memberPersistentAdapter.loadMemberByUsername("agent_username");

			// then
			assertThat(member.getUsername()).isEqualTo("agent_username");
		}

		@Test
		@Sql("classpath:BaseMember.sql")
		void usernameNotFound_ThrowException() {
			// given

			// when
			final ThrowableAssert.ThrowingCallable executable =
				() -> memberPersistentAdapter.loadMemberByUsername("no_username");

			// then
			assertThatThrownBy(executable).isInstanceOf(MemberNotFoundException.class);
		}

	}

}
