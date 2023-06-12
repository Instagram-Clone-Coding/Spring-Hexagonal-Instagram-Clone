package clone.instagram.member.port.out;

import clone.instagram.member.Member;

public interface LoadMemberByUsernamePort {

	Member loadMemberByUsername(String username);

	boolean existsMemberByUsername(String username);

}
