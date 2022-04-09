package com.hospitalajea14019.projecthospitalspring.service.prueba_mongo;

import com.hospitalajea14019.projecthospitalspring.model.prueba_mongo.Books;
import com.hospitalajea14019.projecthospitalspring.repository.prueba_mongo.BooksRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }
    public List<Books> findAll(){
        return booksRepository.findAll();
    }
    public List<Books> findBooksByAuthor(String author){
        return booksRepository.findBooksByAuthor(author);
    }
}
