package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    // 해당 클래스에서 ctrl+shft+t  하면 테스트 클래스 생성 가능
    // static 이기 때문에 MemberRepository가 많이 생성되어도 store, sequence는 딱 하나만 생성됨
    // 13줄 이후로 싱글톤으로 만들었기 때문에 10,11 line에는 static 없어도 싱글톤이 보장되긴 함

    // Spring mvc를 사용하면 Spring에서 Singleton을 보장해주기 때문에 따로 아래와 같이  구현하지 않아도 됨
    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;

    // singleton
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }
    // 아무나 생성하지 못하도록 생성자를 private으로 막아서 singleton 보장
    private MemberRepository(){
    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
