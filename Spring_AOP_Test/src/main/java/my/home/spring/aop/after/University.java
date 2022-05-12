package my.home.spring.aop.after;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("university")
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudents(){
        Student student1 = new Student("Ivan", 19, 3.0);
        Student student2 = new Student("Anton", 18, 4.5);
        Student student3 = new Student("Jamal", 21, 5.0);

        students.add(student1);
        students.add(student2);
        students.add(student3);
    }

    public List<Student> getStudents(){
        System.out.println("Start of getStudents method");
        students.get(100); //throws exception index out of bounds
        System.out.println("From method getStudents" + "\r\n" + students);
        return students;
    }
}
