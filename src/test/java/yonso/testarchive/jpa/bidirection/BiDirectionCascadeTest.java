package yonso.testarchive.jpa.bidirection;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
@DisplayName("양방향, One 에서 cascade All, Many 에서 FetchType.LAZY 테스트")
class BiDirectionCascadeTest {

    @Autowired
    private BiDirectionCascadeOneRepository biDirectionCascadeOneRepository;

    @Autowired
    private BiDirectionCascadeManyRepository biDirectionCascadeManyRepository;

    /*
    * 용어 정리
    * One : OneToMany 관계에서 One 에 해당, One 은 Many 를 List<Many>로 참조
    * Many : OneToMany 관계에서 Many 에 해당, Many 은 Many 를 One 로 참조
    * */

    @DisplayName("""
            One 에 Many 만 추가하고,
            Many 에 One 을 추가하지 않으면
            객체 상에서 양방향 참조가 동기화되지 않은 상태가 발생한다.
            """)
    @Test
    @Transactional
    void test1() {
        BiDirectionCascadeOne one = new BiDirectionCascadeOne();
        BiDirectionCascadeMany many = new BiDirectionCascadeMany();

        one.getMany().add(many);

        // One 은 Many 를 참조한다.
        assertThat(one.getMany()).isNotEmpty();

        // Many 는 One 을 참조하지 않는다.
        assertThat(many.getOne()).isNull();
    }

    @DisplayName("""
            One 에 Many 를 추가하고,
            Many 에 One 을 추가하면
            양방향 참조가 동기화된다.""")
    @Test
    @Transactional
    void test2() {
        BiDirectionCascadeOne one = new BiDirectionCascadeOne();
        BiDirectionCascadeMany many = new BiDirectionCascadeMany();

        one.getMany().add(many);
        many.setOne(one);

        // One 은 Many 를 참조한다.
        assertThat(one.getMany()).isNotEmpty();

        // Many 도 One 을 참조한다.
        assertThat(many.getOne()).isNotNull();
    }

    @DisplayName("""
            One 에 Many 를 추가하고,
            Many 에 One 을 추가하지 않은 상태에서
            One 을 저장하면
            One 과 Many 가 저장되지만,
            저장된 Many 는 One 을 참조하지 않는다.""")
    @Test
    @Transactional
    void test3() {
        BiDirectionCascadeOne one = new BiDirectionCascadeOne();
        BiDirectionCascadeMany many = new BiDirectionCascadeMany();

        one.getMany().add(many);
        BiDirectionCascadeOne savedOne = biDirectionCascadeOneRepository.save(one);

        // One 은 Many 를 참조한다.
        assertThat(one.getMany()).isNotEmpty();

        // Many 는 One 을 참조하지 않는다.
        assertThat(many.getOne()).isNull();

        // One 은 저장된다.
        assertThat(biDirectionCascadeOneRepository.findById(savedOne.getId())).isPresent();

        // Many 도 저장된다. (CascadeType.ALL 때문에)
        BiDirectionCascadeMany savedMany = savedOne.getMany().get(0);
        assertThat(biDirectionCascadeManyRepository.findById(savedMany.getId())).isPresent();

        // 하지만, 저장된 Many 는 One 을 참조하지 않는다.
        assertThat(savedMany.getOne()).isNull();
    }

    @DisplayName("""
            One 에 Many 를 추가하고,
            Many 에 One 을 추가한 상태에서
            One 을 저장하면
            One 과 Many 가 저장되고,
            저장된 Many 는 One 을 참조한다.""")
    @Test
    @Transactional
    void test4() {
        BiDirectionCascadeOne one = new BiDirectionCascadeOne();
        BiDirectionCascadeMany many = new BiDirectionCascadeMany();

        one.getMany().add(many);
        many.setOne(one);
        BiDirectionCascadeOne savedOne = biDirectionCascadeOneRepository.save(one);

        // One 은 Many 를 참조한다.
        assertThat(one.getMany()).isNotEmpty();

        // Many 도 One 을 참조한다.
        assertThat(many.getOne()).isNotNull();

        // One 은 저장된다.
        assertThat(biDirectionCascadeOneRepository.findById(savedOne.getId())).isPresent();

        // Many 도 저장된다. (CascadeType.ALL 때문에)
        BiDirectionCascadeMany savedMany = savedOne.getMany().get(0);
        assertThat(biDirectionCascadeManyRepository.findById(savedMany.getId())).isPresent();

        // 저장된 Many 가 One 을 참조한다.
        assertThat(savedMany.getOne().getId())
                .isEqualTo(savedOne.getId());
    }
}
