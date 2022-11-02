package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import java.util.List;

@Controller
@RequestMapping("/book/form")
@RequiredArgsConstructor
public class BookFormController {
    private final BookService bookService;
    private final PublisherService publisherService;

    @ModelAttribute("publisherList")
    public List<Publisher> getPublishers() {
        return publisherService.findAll();
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/form";
    }

    @PostMapping("/add")
    public String saveForm(Book book) {
        bookService.add(book);
        return "redirect:/book/all";
    }
}
