package my.home.spring.aop.around;

import my.home.spring.aop.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        Library library = context.getBean("library", Library.class);
        library.returnLibraryBook();

        context.close();

    }
}
