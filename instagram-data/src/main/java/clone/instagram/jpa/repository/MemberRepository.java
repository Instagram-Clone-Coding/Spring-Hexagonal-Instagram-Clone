package clone.instagram.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import clone.instagram.jpa.entity.member.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

	boolean existsByUsername(String username);

	Optional<MemberEntity> findMemberEntityByUsername(String username);

}
