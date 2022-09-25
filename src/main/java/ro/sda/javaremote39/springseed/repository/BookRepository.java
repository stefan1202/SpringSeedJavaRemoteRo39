package ro.sda.javaremote39.springseed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.javaremote39.springseed.entities.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findAllByAuthorAndAndTitle(String authorName, String title);
    List<Book> findFirstByAuthorContains(String pattern);

}
