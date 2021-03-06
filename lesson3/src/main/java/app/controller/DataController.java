package app.controller;

import app.entity.Book;
import app.entity.Person;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RequestMapping("/data")
@RestController
public class DataController {
    private static String fmt(String format, Object... args) {
        return String.format(format, args);
    }

    @GetMapping("book")
    public Book handle_book_get(){
        log.info("GET -> /data/book");
        return new Book("JAVA","Jim");
    }

    @GetMapping("person")
    public Person handle_person_get(){
        log.info("GET -> /data/person");
        return new Person(1,"Jim");
    }

    @PostMapping("book")
    public Book handle_book_post(@RequestBody Book book){
        log.info(fmt("POST -> /data/book: %s",book));
        return book;
    }


    @PostMapping("person")
    public Person handle_person_post(@RequestBody Person person){
        log.info(fmt("POST -> /data/person %s", person));
        return person;
    }
}
