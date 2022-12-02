
package domain;

import enums.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    
    @Column(nullable = false,length = 20)
    private String studentFirstName;
    
    @Column(nullable = false,length = 20)
    private String studentLastName;
    
    private LocalDate studentDateOfBirth;
    private String studentAddress;
    
    @OneToMany(mappedBy = "courseStudent")
    private List<Course> courseList;
    
    @Column(columnDefinition = "enum('MALE','FEMALE')")
    @Enumerated(EnumType.STRING)
    private Gender studentSex;
}