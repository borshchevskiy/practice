package my.home.spring.aop.before.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {

//    @Pointcut("execution(* my.home.spring.aop.before.UniversityLibrary.*(..))")
//    private void allMethodsFromUniLibrary(){}
//
//    @Pointcut("execution(public void my.home.spring.aop.before.UniversityLibrary.returnMagazine())")
//    private void returnMagazineFromUniLibrary(){}
//
//    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
//    private void allMethodsExceptReturnMagazineFromUniLibrary(){}
//
//    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")
//    public void beforeAllMethodsExceptReturnMagazineAdvice(){
//        System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: writing Log #4");
//    }


    //----------------------------------------------------------------------



//    @Pointcut("execution(* my.home.spring.aop.before.UniversityLibrary.get*())")
//    private void allGetMethodsFromUniLibrary(){}
//
//    @Pointcut("execution(* my.home.spring.aop.before.UniversityLibrary.return*())")
//    private void allReturnMethodsFromUniLibrary(){}
//
//    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
//    private void allGetOrReturnMethodsFromUniLibrary(){}
//
//    @Before("allGetMethodsFromUniLibrary()")
//    public void beforeGetLoggingAdvice(){
//        System.out.println("beforeGetLoggingAdvice: writing Log #1");
//    }
//
//    @Before("allReturnMethodsFromUniLibrary()")
//    public void beforeReturnLoggingAdvice(){
//        System.out.println("beforeReturnLoggingAdvice: writing Log #2");
//    }
//
//    @Before("allGetOrReturnMethodsFromUniLibrary()")
//    public void beforeGetOrReturnLoggingAdvice(){
//        System.out.println("beforeGetOrReturnLoggingAdvice: writing Log #3");
//    }

    //----------------------------------------------------------------------




////    @Before("execution(public void my.home.spring.aop.before.UniversityLibrary.getBook())")
////    public void beforeGetBookAdvice(){
////        System.out.println("beforeGetBookAdvice: попытка получить книгу");
////    }
//
//    @Before("execution(public void getBook(String))")
//    public void beforeGetBookAdviceWithString(){
//        System.out.println("beforeGetBookAdviceWithString: попытка получить книгу");
//    }

    @Before("my.home.spring.aop.before.aspect.MyPointcuts.allGetMethods()")
    public void beforeGetLoggingAdvice(){
        System.out.println("beforeGetLoggingAdvice: попытка получить что-либо");
    }

    @Before("my.home.spring.aop.before.aspect.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println(signature);
        System.out.println(signature.getMethod());
        System.out.println(signature.getName());


        System.out.println("beforeAddLoggingAdvice: попытка добавить что-либо");
    }

//    @Before("execution(public * returnBook(my.home.spring.aop.before.Book))")
//    public void beforeReturnBookAdvice(){
//        System.out.println("beforeReturnBookAdvice: попытка вернуть книгу");
//    }



}
