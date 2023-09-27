package com.github.SergoShe.model;

import com.github.SergoShe.model.enums.BindingType;
import com.github.SergoShe.model.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private long bookId;
    @Column(name = "title_name")
    private String title;
    private int year;
    @Column(name = "is_damaged")
    private boolean isDamaged;
    @Column(name="service_date")
    private LocalDate serviceDate;
    @Column(name = "status_id")
    private Status status;
    @Column(name = "binding_id")
    private BindingType binding;
    @Column(name="create_date")
    private LocalDate createDate;
    @Column(name="update_date")
    private LocalDate updateDate;

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isDamaged() {
        return isDamaged;
    }

    public void setDamaged(boolean damaged) {
        isDamaged = damaged;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BindingType getBinding() {
        return binding;
    }

    public void setBinding(BindingType binding) {
        this.binding = binding;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }
}
