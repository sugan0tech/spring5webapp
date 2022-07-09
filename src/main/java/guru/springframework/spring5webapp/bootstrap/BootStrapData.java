package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositries.AuthorRepository;
import guru.springframework.spring5webapp.repositries.BookRepository;
import guru.springframework.spring5webapp.repositries.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher pub = new Publisher();
        pub.setName("srk publisher");
        pub.setAddressLine1("Rasipuram");
        pub.setCity("Namakkal");
        pub.setState("Tamil Nadu");
        pub.setZip("36383");
        publisherRepository.save(pub);

        Author eric = new Author();
        eric.setFirstName("2Eec");
        eric.setLastName("Narrow");
        Book ddd = new Book();
        ddd.setTitle("Domain Drivern Design");
        ddd.setIsbn("123455");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(pub);
        pub.getBooks().add(ddd);


        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(pub);

        Author rod = new Author("Rod", "Jhonson");
        Book noEJB = new Book("J2EE", "28283838");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(pub);
        pub.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(pub);
        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books " + bookRepository.count());
        System.out.println("Number of Authors " + authorRepository.count());
        System.out.println(ddd);
        System.out.println(noEJB);
        System.out.println(pub);

    }
}