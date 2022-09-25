package ro.sda.javaremote39.springseed.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ro.sda.javaremote39.springseed.dto.AuthorDto;
import ro.sda.javaremote39.springseed.entities.Author;
import ro.sda.javaremote39.springseed.services.AuthorService;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class AuthorController {

    private AuthorService authorService;

    @GetMapping("/authors")
    public String showAuthor(Model model) {
        List<Author> authorList = authorService.findAll();
        model.addAttribute("authors", authorList);
        return "authors";
    }

    @GetMapping("/authors/create")
    public String showForm(Model model) {
        model.addAttribute("authorForm", new AuthorDto());
        return "author_create";
    }

    @PostMapping("/authors/create")
    public String createAuthor(@ModelAttribute("authorForm") @Valid AuthorDto form, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "author_create";
        }
        authorService.createAuthor(form);
        return "redirect:/authors";
    }

    @GetMapping("/authors/edit/{authorId}")
    public String showEditForm(@PathVariable("authorId") long id, Model model) {//Model e modelul din Spring MVC
        AuthorDto authorForm = authorService.findById(id);
        model.addAttribute("authorForm", authorForm);
        return "author_create";
    }

    @GetMapping("/authors/delete/{authorId}")
    public String deleteAuthor(@PathVariable("authorId") int id, Model model) {//Model e modelul din Spring MVC
        authorService.deleteById(id);
        return "redirect:/authors";
    }


    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }
}
