package pl.examples;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.examples.dao.BookDao;
import pl.examples.model.Book;

@Configuration
@ComponentScan
public class SpringJpaApplication
{

    public static void main( String[] args ) throws InterruptedException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJpaApplication.class);

        BookDao bookDao = ctx.getBean(BookDao.class);
        Book book = new Book("123123223", "Fale i anteny", "Jarosław Szóstka");
        bookDao.save(book);
        System.out.println("Zapisano do bazy danych");
        Book bookFromDb = bookDao.get(1L);
        System.out.println(bookFromDb);

        //to see db open connections
        Thread.sleep(5000);
        ctx.close();

    }
}
