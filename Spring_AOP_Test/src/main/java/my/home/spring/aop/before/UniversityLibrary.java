package my.home.spring.aop.before;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniversityLibrary extends AbstractLibrary {

    private Book book;

    @Autowired
    public UniversityLibrary(Book book) {
        this.book = book;
    }

    public void getBook() {
        System.out.println("We took a book from UniLibrary " + book.getName());
        System.out.println("-------------------------------------------------");
    }

    public void returnBook(){
        System.out.println("We returned a book to UniLibrary");
        System.out.println("-------------------------------------------------");
    }

    public String returnBook(Book book) {
        System.out.println("We returned a book to UniLibrary " + book.getName());
        System.out.println("-------------------------------------------------");
        return "OK";
    }

    public void getMagazine() {
        System.out.println("We took a magazine from UniLibrary");
        System.out.println("-------------------------------------------------");
    }

    public void returnMagazine() {
        System.out.println("We returned a magazine from UniLibrary");
        System.out.println("-------------------------------------------------");
    }

    public void addBook(String personName, Book book) {
        System.out.println("We added a book from UniLibrary");
        System.out.println("-------------------------------------------------");
    }

    public void addMagazine() {
        System.out.println("We added a magazine from UniLibrary");
        System.out.println("-------------------------------------------------");
    }
}
