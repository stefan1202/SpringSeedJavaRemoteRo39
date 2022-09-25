package ro.sda.javaremote39.springseed.services;

import org.springframework.stereotype.Service;

import ro.sda.javaremote39.springseed.dto.AuthorDto;
import ro.sda.javaremote39.springseed.entities.Author;
import ro.sda.javaremote39.springseed.repository.AuthorRepository;

@Service
public class AuthorMapper implements Mapper<Author, AuthorDto> {

    private final AuthorRepository authorRepository;

    public AuthorMapper(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorDto convertToDto(Author entity) {
        AuthorDto authorForm = new AuthorDto();
        authorForm.setId(entity.getId());
        authorForm.setFirstName(entity.getFirstName());
        authorForm.setLastName(entity.getLastName());
        return authorForm;
    }

    @Override
    public Author convertToEntity(AuthorDto dto) {
        Author author;
        if (dto.getId() != null) { // din baza de date aducem o entitate sa lucram cu ea
            author = authorRepository.findById(dto.getId()).orElse(new Author());
        } else { // altfel se va creea alta
            author = new Author();
        }
        author.setId(dto.getId());
        author.setFirstName(dto.getFirstName());
        author.setLastName(dto.getLastName());

        return author;
    }
}
