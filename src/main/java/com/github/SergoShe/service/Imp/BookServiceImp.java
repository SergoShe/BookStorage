package com.github.SergoShe.service.Imp;

import com.github.SergoShe.model.Book;
import com.github.SergoShe.repository.BookRepository;
import com.github.SergoShe.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Transactional
@Service
public class BookServiceImp implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(Book book) {
        book.setCreateDate(LocalDate.now());
        book.setUpdateDate(LocalDate.now());
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book get(long bookId) {
        return bookRepository.findById(bookId).get();
    }

    @Override
    public Book update(Book updatedBook) {
        return bookRepository.findById(updatedBook.getBookId())
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setYear(updatedBook.getYear());
                    book.setBinding(updatedBook.getBinding());
                    book.setStatus(updatedBook.getStatus());
                    book.setDamaged(updatedBook.isDamaged());
                    book.setServiceDate(updatedBook.getServiceDate());
                    book.setCreateDate(updatedBook.getCreateDate());
                    book.setUpdateDate(LocalDate.now());
                    return bookRepository.saveAndFlush(book);
                })
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id " + updatedBook.getBookId()));
    }

    @Override
    public void sendBookToService(long bookId) {
        bookRepository.setServiceStatus(bookId);
    }

    @Override
    public void delete(long bookId) {
        bookRepository.deleteById(bookId);
    }
}
