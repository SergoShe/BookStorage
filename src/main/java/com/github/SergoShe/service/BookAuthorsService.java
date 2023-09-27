package com.github.SergoShe.service;

import java.util.List;

public interface BookAuthorsService {

    void create (Long authorId, Long bookId);

    List<Long> getBookListByAuthorId(long authorId);

    List<Long> getAuthorListByBookId(long bookId);

    boolean deleteAuthor(long authorId);

    boolean deleteBook(long bookId);
}
