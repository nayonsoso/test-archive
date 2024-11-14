package yonso.testarchive.jpa.join;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JpaJoinTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Test
    @DisplayName("연관된 엔티티를 사용해서 query function 을 만들면 join 이 일어난다.")
    void test() {
        Team team = teamRepository.save(new Team("team"));
        Member member = memberRepository.save(new Member("yonso", team));

        memberRepository.findMemberByTeamName("team");
    }
}
