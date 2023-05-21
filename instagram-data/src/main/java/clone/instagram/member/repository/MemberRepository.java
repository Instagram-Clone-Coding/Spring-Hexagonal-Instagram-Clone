package clone.instagram.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import clone.instagram.member.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

	boolean existsByUsername(String username);

	Optional<MemberEntity> findMemberEntityByUsername(String username);

}
