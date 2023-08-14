package com.github.SergoShe.service.Imp;

import com.github.SergoShe.model.Author;
import com.github.SergoShe.service.AuthorService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class AuthorServiceImp implements AuthorService {
    public static final HashMap<Long,Author> AUTHOR_HASH_MAP = new HashMap<>();

    public static final AtomicLong AUTHOR_ID_HOLDER = new AtomicLong();

    @Override
    public void create(Author author) {
        long authorId = AUTHOR_ID_HOLDER.incrementAndGet();
        author.setId(authorId);
        AUTHOR_HASH_MAP.put(authorId,author);
    }

    @Override
    public List<Author> readAll() {
        return new ArrayList<>(AUTHOR_HASH_MAP.values());
    }

    @Override
    public Author read(long id) {
        return AUTHOR_HASH_MAP.get(id);
    }

    @Override
    public boolean update(Author author, long id) {
        if (AUTHOR_HASH_MAP.containsKey(id)){
            author.setId(id);
            AUTHOR_HASH_MAP.put(id,author);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        return AUTHOR_HASH_MAP.remove(id) != null;
    }
}
