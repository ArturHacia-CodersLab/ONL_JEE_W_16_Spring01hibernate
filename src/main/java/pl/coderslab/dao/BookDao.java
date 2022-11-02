package pl.coderslab.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager entityManager;

    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public List<Book> findAll() {
        List<Book> books = entityManager.createQuery("select b from Book b").getResultList();
        books.stream().forEach(this::addAuthorsToBook);
        return books;
    }

    public List<Book> findAllByRating(int rating) {
        Query query = entityManager.createQuery("select b from Book b join fetch b.authors where b.rating = :rating");
        query.setParameter("rating", rating);
        return query.getResultList();
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ? book : entityManager.merge(book));
    }

    private void addAuthorsToBook(Book book) {
        Hibernate.initialize(book.getAuthors());
    }
}
