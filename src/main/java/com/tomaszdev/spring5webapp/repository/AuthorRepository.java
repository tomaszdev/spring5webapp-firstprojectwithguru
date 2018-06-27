package com.tomaszdev.spring5webapp.repository;

import com.tomaszdev.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

}
