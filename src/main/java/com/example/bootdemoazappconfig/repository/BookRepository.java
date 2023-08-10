package com.example.bootdemoazappconfig.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.bootdemoazappconfig.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByIsbn(String isbn);
}
