package pl.examples.dao;

import pl.examples.model.Book;

public interface BookDao {

    public void save(Book book);
    public Book get(Long id);

}
