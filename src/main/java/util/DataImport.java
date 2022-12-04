package util;

import domain.Course;
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
import service.CourseService;
import service.ProfessorService;
import service.StudentService;

public class DataImport {

    static final Logger logger = LoggerFactory.getLogger(DataImport.class.getName());
    private static final String STUDENTS_CSV = "students.csv";
    private static final String PROFESSORS_CSV = "professors.csv";
    private static final String COURSES_CSV = "courses.csv";

    private final StudentService studentService;
    private final ProfessorService professorService;
    private final CourseService courseService;
    
    public DataImport(StudentService studentService, ProfessorService professorService,CourseService courseService) {
        this.studentService = studentService;
        this.professorService = professorService;
        this.courseService = courseService;
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

            logger.warn("Problem opening the file " + filename + "!",ex);
            return null;
        }

        return lines;
    }

    public void insertStudents() {
        List<String[]> studentList = readFile("data/" + STUDENTS_CSV);
        for (String[] studentString : studentList) {
            try {
                Student s = new Student();
                s.setStudentFirstName(studentString[0].trim().toLowerCase());
                s.setStudentLastName(studentString[1].trim().toLowerCase());
                s.setStudentDateOfBirth(LocalDate.parse(studentString[2]));
                s.setStudentAddress(studentString[3]);
                s.setStudentSex(Gender.valueOf(studentString[4]));

                studentService.add(s);
            } catch (Exception e) {
                logger.warn("Something went wrong inserting students", e);
            }
        }
    }

    public void insertProfessors() {
        List<String[]> professorList = readFile("data/" + PROFESSORS_CSV);
        for (String[] courseString : professorList) {
            try {
                Professor p = new Professor();
                p.setProfFirstName(courseString[0].toLowerCase());
                p.setProfLastName(courseString[1].toLowerCase());
                p.setProfDateOfBirth(LocalDate.parse(courseString[2]));
                p.setProfAddress(courseString[3].toLowerCase());
                professorService.add(p);
            } catch (Exception e) {
                logger.error("Something went wrong inserting professors", e);
            }
        }
    }

    public void insertCourses() {
        List<String[]> courseList = readFile("data/courses.csv");
        System.out.println(courseList);
        for (String[] courseString : courseList) {
            try {
                Course c = new Course();
                c.setCourseName(courseString[0].toLowerCase());
                c.setCourseProfessor(professorService.findById(Integer.parseInt(courseString[1])).get());
                c.setStartDate(LocalDate.parse(courseString[2]));
                c.setEndDate(LocalDate.parse(courseString[3]));
                courseService.add(c);
            } catch (Exception e) {
                logger.error("Something went wrong inserting courses", e);
            }
        }
    }

}
