package ro.sda.javaremote39.springseed.repository;

import org.springframework.data.repository.CrudRepository;
import ro.sda.javaremote39.springseed.entities.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
