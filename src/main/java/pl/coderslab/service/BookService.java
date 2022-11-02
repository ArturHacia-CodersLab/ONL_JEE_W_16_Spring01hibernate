package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookDao bookDao;

    public void add(Book book) {
        bookDao.saveBook(book);
    }

    public Book findById(long id) {
        return bookDao.findById(id);
    }

    public List<Book> findAll() {
        return bookDao.findAll();
    }

    public List<Book> findAllByRating(int rating) {
        return bookDao.findAllByRating(rating);
    }

    public void update(Book book) {
        bookDao.update(book);
    }

    public void delete(long id) {
        Book book = bookDao.findById(id);
        bookDao.delete(book);
    }

    public Book changeTitle(long id, String title) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        bookDao.update(book);
        return book;
    }
}
