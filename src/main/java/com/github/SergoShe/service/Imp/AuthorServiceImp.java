package com.github.SergoShe.service.Imp;

import com.github.SergoShe.model.Author;
import com.github.SergoShe.repository.AuthorRepository;
import com.github.SergoShe.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImp implements AuthorService {

    public final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImp(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void create(Author author) {
        authorRepository.createAuthor(author);
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAllAuthors();
    }

    @Override
    public Author get(long authorId) {
        return authorRepository.findAuthorById(authorId);
    }

    @Override
    public long update(Author updatedAuthor) {
            return authorRepository.updateAuthor(updatedAuthor);
    }

    @Override
    public void delete(long authorId) {
        authorRepository.deleteById(authorId);
    }
}
