package clone.instagram.member.adapter.mapper;

import org.springframework.stereotype.Component;

import clone.instagram.global.mapper.ImageMapper;
import clone.instagram.member.Member;
import clone.instagram.member.entity.MemberEntity;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MemberMapper {

	public ImageMapper imageMapper;

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
			member.getEmail()
		);
	}

}
