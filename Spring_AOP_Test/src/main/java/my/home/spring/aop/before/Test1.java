package my.home.spring.aop.before;

import my.home.spring.aop.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        UniversityLibrary universityLibrary = context.getBean("universityLibrary", UniversityLibrary.class);
        Book book = context.getBean("book", Book.class);
//        universityLibrary.getBook();
//        universityLibrary.getMagazine();
        universityLibrary.addBook("Ilya", book);
        universityLibrary.addMagazine();

//        universityLibrary.returnBook();
//        universityLibrary.returnMagazine();

//        universityLibrary.returnBook(book);

//        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
//        schoolLibrary.getBook();
    }
}
