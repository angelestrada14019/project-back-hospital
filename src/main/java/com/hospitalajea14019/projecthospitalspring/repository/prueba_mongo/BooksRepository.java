package com.hospitalajea14019.projecthospitalspring.repository.prueba_mongo;

import com.hospitalajea14019.projecthospitalspring.model.prueba_mongo.Books;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends MongoRepository<Books,String> {
    public List<Books> findBooksByAuthor(String author);
}
