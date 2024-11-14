package yonso.testarchive.jpa.join;

import static jakarta.persistence.GenerationType.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    public Team(String name) {
        this.name = name;
    }
}
