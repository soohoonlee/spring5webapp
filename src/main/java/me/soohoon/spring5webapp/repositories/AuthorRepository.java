package me.soohoon.spring5webapp.repositories;

import me.soohoon.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
