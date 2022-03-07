package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //optional은 null일때를 대비해서 만들어주는것
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
