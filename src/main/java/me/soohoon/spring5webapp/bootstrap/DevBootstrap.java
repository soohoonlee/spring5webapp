package me.soohoon.spring5webapp.bootstrap;

import me.soohoon.spring5webapp.model.Author;
import me.soohoon.spring5webapp.model.Book;
import me.soohoon.spring5webapp.repositories.AuthorRepository;
import me.soohoon.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private AuthorRepository authorRepository;
  private BookRepository bookRepository;

  public DevBootstrap(final AuthorRepository authorRepository,
      final BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  @Override
  public void onApplicationEvent(final ContextRefreshedEvent event) {
    initData();
  }

  private void initData() {
    // Eric
    final Author eric = new Author("Eric", "Evans");
    final Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);

    authorRepository.save(eric);
    bookRepository.save(ddd);

    // Rod
    final Author rod = new Author("Rod", "Johnson");
    final Book noEJB = new Book("J2EE Development without EJB", "23444", "Worx");
    rod.getBooks().add(noEJB);

    authorRepository.save(rod);
    bookRepository.save(noEJB);
  }
}
