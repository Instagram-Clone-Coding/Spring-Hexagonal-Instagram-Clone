package clone.instagram.member.out.adapter;

import org.springframework.stereotype.Component;

import clone.instagram.error.exception.member.MemberNotFoundException;
import clone.instagram.member.Member;
import clone.instagram.jpa.mapper.MemberMapper;
import clone.instagram.jpa.entity.member.MemberEntity;
import clone.instagram.member.port.out.LoadMemberByUsernamePort;
import clone.instagram.member.port.out.SaveMemberPort;
import clone.instagram.jpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MemberPersistentAdapter implements LoadMemberByUsernamePort, SaveMemberPort {

	private final MemberMapper memberMapper;
	private final MemberRepository memberRepository;

	@Override
	public Member loadMemberByUsername(String username) {
		final MemberEntity memberEntity = memberRepository.findMemberEntityByUsername(username)
			.orElseThrow(MemberNotFoundException::new);
		return memberMapper.mapToDomainModel(memberEntity);
	}

	@Override
	public boolean existsMemberByUsername(String username) {
		return memberRepository.existsByUsername(username);
	}

	@Override
	public void saveMember(Member member) {
		final MemberEntity memberEntity = memberMapper.mapToJpaEntity(member);
		memberRepository.save(memberEntity);
	}

}
