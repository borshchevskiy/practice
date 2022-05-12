package my.home.spring.aop.before.aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class MyPointcuts {

    @Pointcut("execution(* my.home.spring.aop.before.UniversityLibrary.get*())")
    public void allGetMethods(){}

    @Pointcut("execution(* my.home.spring.aop.before.UniversityLibrary.add*(..))")
    public void allAddMethods(){}
}
