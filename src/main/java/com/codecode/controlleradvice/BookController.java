package com.codecode.controlleradvice;

import ch.qos.logback.core.util.StringUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class BookController {
    public static Map<Integer, String> bookShelf = new HashMap<>();

    static {
        bookShelf.put(1001, "Clean Code");
        bookShelf.put(1002, "Effective Java");
        bookShelf.put(1003, "Design Patterns");
        bookShelf.put(1004, "Refactoring");
        bookShelf.put(1005, "The Pragmatic Programmer");
    }


    @GetMapping("/book/{id}")
    public ResponseEntity<BookModel> getBook(@PathVariable Integer id) throws ResourceNotFoundException {
        String bookName;
        bookName = bookShelf.get(id);
        if (StringUtil.isNullOrEmpty(bookName)) {
            throw new ResourceNotFoundException("Not Found");
        }
        BookModel book = new BookModel(id, bookName);
        book.add(linkTo(methodOn(BookController.class).getBook(id)).withSelfRel());
        book.add(linkTo(methodOn(BookController.class).getBooks()).withRel("all-books"));

        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }


    @GetMapping("/books")
    public ResponseEntity<List<BookModel>> getBooks() {
        List<BookModel> books = bookShelf
                .entrySet()
                .stream()
                .map(book -> {
                    BookModel nBook = new BookModel(book.getKey(), book.getValue());
                    try {
                        nBook.add(linkTo(methodOn(BookController.class).getBook(book.getKey())).withSelfRel());
                    } catch (ResourceNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    return nBook;
                }).
                collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.CREATED).

                body(books);
    }


    @PostMapping("/book")
    public ResponseEntity<BookModel> add(@RequestBody BookModel book) {
        bookShelf.put(book.getIspn(), book.getTitle());
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }


    @PutMapping("/book/{id}")
    public ResponseEntity<BookModel> update(@PathVariable Integer id, @RequestBody BookModel book) throws ResourceNotFoundException {

        String name = bookShelf.get(id);
        System.out.println(" Name  is " + name);
        if (!StringUtil.isNullOrEmpty(name)) {
            bookShelf.put(id, book.getTitle());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(book);
        } else {
            throw new ResourceNotFoundException("The resource you are trying to access is unavailable");
        }
    }

    @PatchMapping("/book/{id}")
    public ResponseEntity<BookModel> patch(@PathVariable Integer id, @RequestBody BookModel patchReq) throws ResourceNotFoundException {
        String name = bookShelf.get(id);
        System.out.println(" Name  is " + name);
        if (!StringUtil.isNullOrEmpty(name)) {

            if (patchReq.getTitle() != null) {
                name = patchReq.getTitle();
            }

            bookShelf.put(id, name);
            return ResponseEntity.ok(new BookModel(id, name));
        } else {
            throw new ResourceNotFoundException("Inaccessible Resources");
        }

    }
}
