package clone.instagram.jpa.mapper;

import org.springframework.stereotype.Component;

import clone.instagram.jpa.entity.member.MemberEntity;
import clone.instagram.member.Member;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MemberMapper {

	private final ImageMapper imageMapper;

	public Member mapToDomainModel(MemberEntity member) {
		return new Member(
			member.getId(),
			member.getUsername(),
			member.getPassword(),
			member.getName(),
			member.getEmail(),
			member.getWebsite(),
			member.getIntroduce(),
			member.getPhone(),
			member.getGender(),
			imageMapper.mapToDomainModel(member.getImage())
		);
	}

	public MemberEntity mapToJpaEntity(Member member) {
		return new MemberEntity(
			member.getUsername(),
			member.getPassword(),
			member.getName(),
			member.getEmail(),
			imageMapper.mapToJpaEntity(member.getImage())
		);
	}

}
