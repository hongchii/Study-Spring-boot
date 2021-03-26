package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원을 저장소에 저장
    Optional<Member> findById(Long id); // id 반환
    // null을 그냥 반환하지않고 Optional로 감싸서 반환함
    Optional<Member> findByName(String name); // name 반환
    List<Member> findAll(); // 저장된 회원 리스트 전부 반환
}
