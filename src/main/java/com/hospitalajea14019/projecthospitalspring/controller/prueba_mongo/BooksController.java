package com.hospitalajea14019.projecthospitalspring.controller.prueba_mongo;

import com.hospitalajea14019.projecthospitalspring.model.prueba_mongo.Books;
import com.hospitalajea14019.projecthospitalspring.service.prueba_mongo.BooksService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mongoexample")
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }
    @GetMapping("")
    public List<Books> findAll(){
        return booksService.findAll();
    }
    @GetMapping({"/{author}"})
    public List<Books> findBooksByAuthor(@PathVariable String author){
        return booksService.findBooksByAuthor(author);
    }
}
