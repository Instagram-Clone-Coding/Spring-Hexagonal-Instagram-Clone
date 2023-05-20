package member.port.out;

import member.Member;

public interface LoadMemberByIdPort {

	Member loadMemberById(Long memberId);
	boolean existsMemberById(Long memberId);

}
