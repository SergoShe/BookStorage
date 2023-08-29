package com.github.SergoShe.service;

import java.util.List;

public interface BookAuthorsService {

    void create (Long authorId, Long bookId);

    List<Long> getBooksId(long authorId);

    List<Long> getAuthorsId(long bookId);

    boolean deleteAuthor(long authorId);

    boolean deleteBook(long bookId);
}
