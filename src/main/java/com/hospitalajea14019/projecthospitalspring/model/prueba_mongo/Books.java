package com.hospitalajea14019.projecthospitalspring.model.prueba_mongo;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "books")
public class Books {

    @Id
    private String id;
    private String author;
    @Field(name = "book")
    private String book;

}
