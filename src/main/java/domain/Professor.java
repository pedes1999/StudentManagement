package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
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

    @Column(name = "fname" ,nullable = false, length = 20)
    private String profFirstName;

    @Column(name = "lname" ,nullable = false, length = 20)
    private String profLastName;
    
    @Column(name = "DOB" ,nullable = false)
    private LocalDate profDateOfBirth;
    
    @Column(name = "address" ,nullable = false, length = 50)
    private String profAddress;

    @OneToMany(mappedBy = "courseProfessor",orphanRemoval = true)
    private List<Course> ProfessorTeaches;

    public Professor(String profFirstName, String profLastName, LocalDate profDateOfBirth, String profAddress) {
        this.profFirstName = profFirstName;
        this.profLastName = profLastName;
        this.profDateOfBirth = profDateOfBirth;
        this.profAddress = profAddress;
    }
    
    

}
