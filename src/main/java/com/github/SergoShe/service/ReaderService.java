package com.github.SergoShe.service;

import com.github.SergoShe.model.Reader;

import java.util.List;

public interface ReaderService {
    Reader createReader(Reader reader);

    List<Reader> getAllReaders();

    Reader getReader(long readerId);

    Reader updateReader(Reader reader);

    boolean deleteReader(long readerId);
}
