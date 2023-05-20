package member.port.out;

import member.Member;

public interface LoadMemberByUsernamePort {

	Member loadMemberByUsername(String username);
	boolean existsMemberByUsername(String username);

}
