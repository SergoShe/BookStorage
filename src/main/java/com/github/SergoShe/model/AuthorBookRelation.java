package com.github.SergoShe.model;

public class AuthorBookRelation {

    private long id;
    private long authorId;
    private long bookId;

    public AuthorBookRelation(long id, long authorId, long bookId) {
        this.id = id;
        this.authorId = authorId;
        this.bookId = bookId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

}
