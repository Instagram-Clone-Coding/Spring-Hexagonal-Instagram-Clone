package clone.instagram.member.adapter;

import org.springframework.stereotype.Component;

import clone.instagram.member.Member;
import clone.instagram.member.adapter.mapper.MemberMapper;
import clone.instagram.member.entity.MemberEntity;
import clone.instagram.member.port.out.LoadMemberByUsernamePort;
import clone.instagram.member.port.out.SaveMemberPort;
import clone.instagram.member.repository.MemberRepository;
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
