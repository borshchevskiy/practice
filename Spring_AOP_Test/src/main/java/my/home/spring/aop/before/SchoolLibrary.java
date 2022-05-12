package my.home.spring.aop.before;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary extends AbstractLibrary {

    public void getBook() {
        System.out.println("We took a book School Library");
    }
}
