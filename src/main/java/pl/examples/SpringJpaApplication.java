package pl.examples;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.examples.dao.BookDao;
import pl.examples.model.Book;

import java.time.LocalDate;

@Configuration
@ComponentScan
public class SpringJpaApplication
{

    public static void main( String[] args ) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJpaApplication.class);

        BookDao bookDao = ctx.getBean(BookDao.class);
        LocalDate now = LocalDate.now();
        Book book = new Book("123123223", "Fale i anteny", "Jarosław Szóstka");
        bookDao.save(book);


        Book bookFromDb = bookDao.get(1L);
        System.out.println(bookFromDb);
        ctx.close();

    }
}
