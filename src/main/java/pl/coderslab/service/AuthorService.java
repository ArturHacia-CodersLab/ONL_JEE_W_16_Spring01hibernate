package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorDao authorDao;

    public Author findById(long id) {
        return authorDao.findById(id);
    }

    public List<Author> findAll() {
        return authorDao.findAll();
    }

    public void saveAuthor(Author author) {
        authorDao.saveAuthor(author);
    }

    public void update(Author author) {
        authorDao.update(author);
    }

    public void delete(Author author) {
        authorDao.delete(author);
    }
}
