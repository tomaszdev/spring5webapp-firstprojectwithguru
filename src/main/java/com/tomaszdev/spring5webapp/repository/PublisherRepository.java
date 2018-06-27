package com.tomaszdev.spring5webapp.repository;

import com.tomaszdev.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Integer> {
}
