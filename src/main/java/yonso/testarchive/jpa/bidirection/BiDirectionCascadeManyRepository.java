package yonso.testarchive.jpa.bidirection;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiDirectionCascadeManyRepository extends JpaRepository<BiDirectionCascadeMany, Long> {

    List<BiDirectionCascadeMany> findAllByOneId(long id);
}
