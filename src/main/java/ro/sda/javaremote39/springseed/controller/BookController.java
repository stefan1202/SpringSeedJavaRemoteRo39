package ro.sda.javaremote39.springseed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ro.sda.javaremote39.springseed.dto.BookDto;
import ro.sda.javaremote39.springseed.services.BookService;

import javax.validation.Valid;
import java.util.List;

@Controller

public class BookController {
    @Autowired
    private BookService bookService;


    @GetMapping("/books")
    public String showBooks(Model model) {
        List<BookDto> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/books/create")
    public String showForm(Model model) {
        model.addAttribute("bookForm", new BookDto());
        return "book_create";
    }

    @PostMapping("/books/create")
    public String createBook(@ModelAttribute("bookForm") @Valid BookDto form, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "book_create";
        }
        bookService.createBook(form);
        return "redirect:/books";
    }

    @GetMapping("/books/edit/{bookId}")
    public String showEditForm(@PathVariable("bookId") int id, Model model) {//Model e modelul din Spring MVC
        BookDto bookForm = bookService.findById(id);
        model.addAttribute("bookForm", bookForm);
        return "book_create";
    }
    @GetMapping("/books/delete/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id, Model model) {//Model e modelul din Spring MVC
       bookService.deleteById(id);
        return "redirect:/books";
    }
}
