package com.github.SergoShe.repository;

import com.github.SergoShe.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
/*
    @Modifying
    @Query(value = "UPDATE book SET status_id = :statusId WHERE book_id = :bookId", nativeQuery = true)
    void setServiceStatus(@Param("statusId") int statusId, @Param("bookId") long bookId);

 */
}
