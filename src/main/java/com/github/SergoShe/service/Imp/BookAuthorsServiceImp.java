package com.github.SergoShe.service.Imp;

import com.github.SergoShe.model.AuthorBookRelation;
import com.github.SergoShe.service.BookAuthorsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookAuthorsServiceImp implements BookAuthorsService {
    public static final HashMap<Long, AuthorBookRelation> RELATION_HASH_MAP = new HashMap<>();

    public static final AtomicLong RELATION_ID_HOLDER = new AtomicLong();

    @Override
    public void create(Long authorId, Long bookId) {
        long relationId = RELATION_ID_HOLDER.incrementAndGet();
        AuthorBookRelation relation = new AuthorBookRelation(relationId, authorId, bookId);
        RELATION_HASH_MAP.put(relationId, relation);
    }

    @Override
    public List<Long> getBooksId(long authorId) {
        return RELATION_HASH_MAP.values().stream()
                .filter(x -> x.getAuthorId() == authorId).map(AuthorBookRelation::getBookId).toList();
    }

    @Override
    public List<Long> getAuthorsId(long bookId) {
        return RELATION_HASH_MAP.values().stream()
                .filter(x -> x.getBookId() == bookId).map(AuthorBookRelation::getAuthorId).toList();
    }

    @Override
    public boolean deleteAuthor(long authorId) {
        try {
            RELATION_HASH_MAP.values().stream().filter(x -> x.getAuthorId() == authorId)
                    .map(AuthorBookRelation::getId).forEach(RELATION_HASH_MAP::remove);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteBook(long bookId) {
        try {
            RELATION_HASH_MAP.values().stream().filter(x -> x.getAuthorId() == bookId)
                    .map(AuthorBookRelation::getId).forEach(RELATION_HASH_MAP::remove);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
