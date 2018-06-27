package com.tomaszdev.spring5webapp.bootstrap;

import com.tomaszdev.spring5webapp.model.Author;
import com.tomaszdev.spring5webapp.model.Book;
import com.tomaszdev.spring5webapp.model.Publisher;
import com.tomaszdev.spring5webapp.repository.AuthorRepository;
import com.tomaszdev.spring5webapp.repository.BookRepository;
import com.tomaszdev.spring5webapp.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    @Autowired
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Author eric = new Author("Eric", "Evans");
        Publisher harpercollins = new Publisher("Harper Collins", "Montana");
        publisherRepository.save(harpercollins);
        Book ddd = new Book("Domain Driven Design", "1234", harpercollins);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Publisher worx = new Publisher("Worx", "Washington");
        publisherRepository.save(worx);
        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
        rod.getBooks().add(noEJB);


        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }


}
