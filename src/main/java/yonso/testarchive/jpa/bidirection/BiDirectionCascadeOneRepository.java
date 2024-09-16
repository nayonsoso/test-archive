package yonso.testarchive.jpa.bidirection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiDirectionCascadeOneRepository extends JpaRepository<BiDirectionCascadeOne, Long> {
}
