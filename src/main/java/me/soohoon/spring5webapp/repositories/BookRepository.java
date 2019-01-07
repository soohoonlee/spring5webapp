package me.soohoon.spring5webapp.repositories;

import me.soohoon.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
