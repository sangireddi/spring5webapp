package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Address;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData  implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eswar=new Author("eswar","sangireddi");
        Book book1=new Book("Spring Framework","ISBN:12345");

        eswar.getBooks().add(book1);
        book1.getAuthors().add(eswar);

        Author rohini = new Author("rohini","sangireddi");
        Book book2=new Book("Brain Tuning","ISBN:6789");

        eswar.getBooks().add(book2);
        book1.getAuthors().add(rohini);

        authorRepository.save(eswar);
        authorRepository.save(rohini);
        bookRepository.save(book1);
        bookRepository.save(book2);

        System.out.println("Number of Books :"+bookRepository.count());

        Address address1=new Address("street 1","hyd","telangana","500090");

        Publisher publisher=new Publisher("eswar sangireddi",address1);

        publisherRepository.save(publisher);

        System.out.println(" PUBLISHER : "+ publisher);

    }
}
