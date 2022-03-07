package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //null 이 있을수도 있으니 Optional.ofNUllable을 넣음
    }

    @Override
    public Optional<Member> findByName(String name) {

        return store.values().stream()
                .filter(member -> member.getName().equals(name)) //member의 getName이 파라미터의 name과 같은 경우
                .findAny(); //findAny는 하나라도 찾으면 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
