package com.tomaszdev.spring5webapp.repository;

import com.tomaszdev.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
