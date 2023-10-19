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
    public void createAuthor(Author author) {
        authorRepository.createAuthor(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAllAuthors();
    }

    @Override
    public Author getAuthor(long authorId) {
        return authorRepository.findAuthorById(authorId);
    }

    @Override
    public Author updateAuthor(Author updatedAuthor) {
        return authorRepository.updateAuthor(updatedAuthor);
    }

    @Override
    public boolean deleteAuthor(long authorId) {
        long deletedId = authorRepository.deleteAuthorById(authorId);
        return authorId == deletedId;
    }
}
