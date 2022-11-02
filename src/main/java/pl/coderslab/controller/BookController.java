package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    @RequestMapping("/book/add")
    @ResponseBody
    public String hello() {
        Publisher publisher = new Publisher();
        publisher.setName("Helion");
        publisherService.savePublisher(publisher);

        Author author1 = new Author();
        author1.setFirstName("Adam");
        author1.setLastName("Mickiewicz");
        authorService.saveAuthor(author1);

        Author author2 = new Author();
        author2.setFirstName("Henryk");
        author2.setLastName("Sienkiewicz");
        authorService.saveAuthor(author2);

        List<Author> authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);

        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setPublisher(publisher);
        book.setAuthors(authors);
        bookService.add(book);
        return "Id dodanej książki to:" + book.getId();
    }

    @RequestMapping("/book/get/{id}")
    @ResponseBody
    public String getBook(@PathVariable long id) {
        Book book = bookService.findById(id);
        return book.toString();
    }

    @RequestMapping("/book/all")
    public String getAllBook(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "/book/list";
    }

    @RequestMapping("/book/rating/{rating}")
    @ResponseBody
    public String findAllByRating(@PathVariable int rating) {
        return bookService.findAllByRating(rating).toString();
    }

    @RequestMapping("/book/update/{id}/{title}")
    @ResponseBody
    public String updateBook(@PathVariable long id, @PathVariable String title ) {
        Book book = bookService.changeTitle(id, title);
        return book.toString();
    }

    @RequestMapping("/book/delete/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        bookService.delete(id);
        return "deleted";
    }
}
