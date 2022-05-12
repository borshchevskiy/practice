package my.home.spring.aop.around;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LibraryBook {
    @Value("Преступление и наказание")
    private String name;
    @Value("Ф. Достоевский")
    private String author;
    @Value("1866")
    private int year;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}
