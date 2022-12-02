package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int professorId;

    @Column(nullable = false, length = 20)
    private String profFirstName;

    @Column(nullable = false, length = 20)
    private String profLastName;

    private Integer profDateOfBirth;
    private String profAddress;

    @OneToMany(mappedBy = "courseProfessor", orphanRemoval = true)
    private List<Course> ProfessorTeaches;

}
