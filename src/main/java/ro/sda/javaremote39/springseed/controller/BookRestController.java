package ro.sda.javaremote39.springseed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.sda.javaremote39.springseed.dto.BookDto;
import ro.sda.javaremote39.springseed.services.BookService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookRestController {

    @Autowired
    private BookService bookService;
    @GetMapping
    public List<BookDto> getAllBooks(){
        return bookService.getAllBooks();

    }

    @PostMapping
    public  BookDto createBook(@Valid @RequestBody BookDto bookDto){
        return bookService.createBook(bookDto);
    }
}
