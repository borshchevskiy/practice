package my.home.spring.aop.around;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Library {
    private LibraryBook libraryBook;

    @Autowired
    public Library(LibraryBook libraryBook) {
        this.libraryBook = libraryBook;
    }

    public LibraryBook getLibraryBook() {
        return libraryBook;
    }

    public String returnLibraryBook() {
        int a = 10/0;
        System.out.println("Returning book to library");
        return libraryBook.getName();
    }


}
