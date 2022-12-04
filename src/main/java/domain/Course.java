package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    
    @Column(nullable = false,length = 20)
    private String courseName;
    
    @ManyToOne()
    private Professor courseProfessor;
    
    @ManyToOne()
    private Student courseStudent;
    
    private LocalDate startDate;
    private LocalDate endDate;

    public Course(String courseName, Professor courseProfessor, LocalDate startDate, LocalDate endDate) {
        this.courseName = courseName;
        this.courseProfessor = courseProfessor;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    
    
    
}
