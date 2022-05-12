package my.home.spring.aop.around.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LibraryLoggingAspect {

    @Around("execution(public String returnLibraryBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: Trying to return book");

        Object target = null;
        try {
            target = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("Caught an exception " + e);
            target = "defaultBookName";
        }

        System.out.println("aroundReturnBookLoggingAdvice: Book returned");

        return target;
    }
}
