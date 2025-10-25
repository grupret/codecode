package com.codecode.controlleradvice;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
public class BookModel extends RepresentationModel<BookModel> {

    private Integer ispn;
    private String title;
    private String author;

    public BookModel(Integer id, String bookName) {
        ispn = id;
        title = bookName;
        author = "Gru";


    }

    // getters/setters
}