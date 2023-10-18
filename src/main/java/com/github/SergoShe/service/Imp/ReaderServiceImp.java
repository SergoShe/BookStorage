package com.github.SergoShe.service.Imp;

import com.github.SergoShe.model.Reader;
import com.github.SergoShe.repository.ReaderRepository;
import com.github.SergoShe.service.ReaderService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ReaderServiceImp implements ReaderService {

    private final ReaderRepository readerRepository;

    public ReaderServiceImp(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @Override
    public Reader createReader(Reader reader) {
        return readerRepository.createReader(reader);
    }

    @Override
    public List<Reader> getAllReaders() {
        return readerRepository.findAllReaders();
    }

    @Override
    public Reader getReader(long readerId) {
        return readerRepository.findReaderById(readerId);
    }

    @Override
    public Reader updateReader(Reader reader) {
        return readerRepository.updateReader(reader);
    }

    @Override
    public boolean deleteReader(long readerId) {
        long deletedId = readerRepository.deleteReaderById(readerId);
        return readerId == deletedId;
    }
}
