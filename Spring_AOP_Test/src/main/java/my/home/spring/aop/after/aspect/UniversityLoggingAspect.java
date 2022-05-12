package my.home.spring.aop.after.aspect;

import my.home.spring.aop.after.Student;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {
//    @Before("execution(* getStudents())")
//    public void beforeGetStudentsLoggingAdvice() {
//        System.out.println("beforeGetStudentsLoggingAdvice: Logging before getStudents()");
//    }

    @AfterReturning(pointcut = "execution(* getStudents())",
            returning = "students")
    public void afterReturningGetStudentsLoggingAdvice(List<Student> students) {
        Student firstStudent = students.get(0);

        String name = firstStudent.getName();
        name = "Mr. " + name;
        firstStudent.setName(name);

        double avgGrade = firstStudent.getAverageGrade();
        avgGrade+=1;
        firstStudent.setAverageGrade(avgGrade);

        System.out.println("afterReturningGetStudentsLoggingAdvice: Logging after returning getStudents()");
    }

    @AfterThrowing(pointcut = "execution(* getStudents())",
    throwing = "exception")
    public void afterThrowingGetStudentsLoggingAdvice(Throwable exception){
        System.out.println("afterThrowingGetStudentsLoggingAdvice: Logging after throwing exception");
        System.out.println(exception);
    }

    @After("execution(* getStudents())")
    public void afterGetStudentsLoggingAdvice(){
        System.out.println("afterGetStudentsLoggingAdvice: Logging after method getStudents");
    }

}
