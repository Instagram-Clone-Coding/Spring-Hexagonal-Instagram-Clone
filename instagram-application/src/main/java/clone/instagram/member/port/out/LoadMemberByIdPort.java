package clone.instagram.member.port.out;

import clone.instagram.member.Member;

public interface LoadMemberByIdPort {

	Member loadMemberById(Long memberId);

	boolean existsMemberById(Long memberId);

}
