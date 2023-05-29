package member.out.adapter;

import org.springframework.stereotype.Component;

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
		// TODO 예외 처리
		final MemberEntity memberEntity = memberRepository.findMemberEntityByUsername(username)
			.orElseThrow(() -> new RuntimeException("Member entity not exists."));
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
