package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositries.AuthorRepository;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {
    private final AuthorRepository authorRepository;
    public AuthorController(AuthorRepository authorRepository){this.authorRepository = authorRepository;};

}
