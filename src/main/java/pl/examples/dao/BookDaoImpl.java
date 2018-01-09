package pl.examples.dao;

import org.springframework.stereotype.Repository;
import pl.examples.model.Book;

import javax.persistence.*;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceUnit
    private EntityManagerFactory emFactory;

    BookDaoImpl() {
    }

    @Override
    public void save(Book book) {
        EntityManager entityManager = emFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(book);
        tx.commit();
        entityManager.close();
    }

    @Override
    public Book get(Long id) {
        EntityManager entityManager = emFactory.createEntityManager();
        Book book = entityManager.find(Book.class, id);
        entityManager.close();
        return book;
    }
}
