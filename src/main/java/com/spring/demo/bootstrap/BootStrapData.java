package com.spring.demo.bootstrap;

import com.spring.demo.domain.Author;
import com.spring.demo.domain.Book;
import com.spring.demo.domain.Publisher;
import com.spring.demo.repositories.AuthorRepository;
import com.spring.demo.repositories.BookRepository;
import com.spring.demo.repositories.PublisherRepository;
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

    Author brian = new Author("Brian", "Evans");
    Book mystery = new Book("Stranger in the house", "123123");

    Publisher penguin = new Publisher("Penguin", "20, Main Street, 32029");
    Publisher eagle = new Publisher("Eagle", "15, Bethel Road, 39201");

    brian.getBooks().add(mystery);
    mystery.getAuthors().add(brian);
//    mystery.setPublisher(penguin);
    penguin.getBooks().add(mystery);

    authorRepository.save(brian);
    bookRepository.save(mystery);
    publisherRepository.save(penguin);

    Author lin = new Author("Lin", "Parks");
    Book thriller = new Book("New Neighbour", "3939459459");
    lin.getBooks().add(thriller);
    thriller.getAuthors().add(lin);
//    thriller.setPublisher(eagle);
    eagle.getBooks().add(thriller);

    authorRepository.save(lin);
    bookRepository.save(thriller);
    publisherRepository.save(eagle);

    System.out.println("Started in Bootstrap");
    System.out.println("Number of Books: " + bookRepository.count());
    System.out.println("No of publishers are " +publisherRepository.count());
    System.out.println("Penguin publisher No of Books " +penguin.getBooks().size());

  }
}

