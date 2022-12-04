package util;

import domain.Professor;
import domain.Student;
import enums.Gender;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.ProfessorService;
import service.StudentService;

public class DataImport {
    static final Logger logger = LoggerFactory.getLogger(DataImport.class.getName());
    private static final String STUDENTS_CSV = "students.csv";
    private static final String PROFESSORS_CSV = "professors.csv";
    
    
    private StudentService studentService;
    private ProfessorService professorService;

    public DataImport(StudentService studentService, ProfessorService professorService) {
        this.studentService = studentService;
        this.professorService = professorService;
    }
    
    
    
     private static List<String[]> readFile(String filename) {
        List<String[]> lines = new ArrayList<>();
        String string;
        try ( BufferedReader reader = new BufferedReader(new FileReader(filename));) {
            String headerLine = reader.readLine();
            while ((string = reader.readLine()) != null) {
                lines.add(string.split(","));
            }
            reader.close();
        } catch (IOException ex) {

            System.out.println("Problem openning the file " + filename + "!");
            return null;
        }

        return lines;
    }
     
     public void insertStudents(){
         List<String[]> studentList = readFile("data/" + STUDENTS_CSV);
         for (String[] studentString : studentList){
             try {
                 Student s = new Student();
                 s.setStudentFirstName(studentString[0].trim().toLowerCase());
                 s.setStudentLastName(studentString[1].trim().toLowerCase());
                 s.setStudentDateOfBirth(LocalDate.parse(studentString[2]));
                 s.setStudentAddress(studentString[3]);
                 s.setStudentSex(Gender.valueOf(studentString[4]));
                 
                 studentService.add(s);
             } catch(Exception e){
                 logger.warn("Something went wrong inserting students" , e);
             }
         }
     }
     
     public void insertProfessors(){
         List<String[]> professorList = readFile("data/" + PROFESSORS_CSV);
         for(String[] profString : professorList){
             try {
             Professor p = new Professor();
             p.setProfFirstName(profString[0]);
             p.setProfLastName(profString[1]);
             p.setProfDateOfBirth(LocalDate.parse(profString[2]));
             p.setProfAddress(profString[3]);
             professorService.add(p);
             } catch (Exception e) {
                 logger.error("Something went wrong inserting professors", e);
             }
         }
     }
    
}
