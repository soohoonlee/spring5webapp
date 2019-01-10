package me.soohoon.spring5webapp.controllers;

import me.soohoon.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorController {

  private AuthorRepository authorRepository;

  public AuthorController(final AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @GetMapping("/authors")
  public String getAuthors(final Model model) {
    model.addAttribute("authors", authorRepository.findAll());
    return "authors";
  }
}
