package yonso.testarchive.jpa.save;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import yonso.testarchive.jpa.join.Team;
import yonso.testarchive.jpa.join.TeamRepository;

@SpringBootTest
public class SaveTimeComparingTest {

    @Autowired
    private TeamRepository teamRepository;

    @Test
    @Transactional
    @DisplayName("save 시간 측정")
    void test() {
        // 데이터 준비
        List<Team> team1 = new LinkedList<>();
        List<Team> team2 = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            team1.add(new Team("team" + i));
            team2.add(new Team("team" + i));
        }

        // save 시간 측정
        long saveStart = System.nanoTime();
        for (Team t : team1) {
            teamRepository.save(t);
        }
        long saveEnd = System.nanoTime();

        // saveAll 시간 측정
        long saveAllStart = System.nanoTime();
        teamRepository.saveAll(team2);
        long saveAllEnd = System.nanoTime();

        System.out.println("save time: " + (saveEnd - saveStart) / 1000000 + "ms");
        System.out.println("saveAll time: " + (saveAllEnd - saveAllStart) / 1000000 + "ms");
        // 결과 : save time: 57ms, saveAll time: 22ms
        // saveAll 은 하나의 트랜잭션으로 처리되므로 save 보다 더 빠르다.
    }
}
