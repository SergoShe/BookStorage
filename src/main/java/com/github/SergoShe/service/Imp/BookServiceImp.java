package com.github.SergoShe.service.Imp;

import com.github.SergoShe.model.Book;
import com.github.SergoShe.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookServiceImp implements BookService {

    private static final HashMap<Long,Book> BOOK_HASH_MAP = new HashMap<>();

    private static final AtomicLong BOOK_ID_HOLDER = new AtomicLong();

    @Override
    public void create(Book book) {
        long bookId = BOOK_ID_HOLDER.incrementAndGet();
        book.setId(bookId);
        BOOK_HASH_MAP.put(bookId,book);
    }

    @Override
    public List<Book> readAll() {
        return new ArrayList<>(BOOK_HASH_MAP.values());
    }

    @Override
    public Book read(long id) {
        return BOOK_HASH_MAP.get(id);
    }

    @Override
    public boolean update(Book book, long id) {
        if (BOOK_HASH_MAP.containsKey(id)){
            book.setId(id);
            BOOK_HASH_MAP.put(id,book);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        return BOOK_HASH_MAP.remove(id) != null;
    }
}
