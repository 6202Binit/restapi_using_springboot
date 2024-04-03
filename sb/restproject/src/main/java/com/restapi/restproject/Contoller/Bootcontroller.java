package com.restapi.restproject.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.restproject.Service.BookService;
import com.restapi.restproject.entity.Book;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class Bootcontroller {
    //@RequestMapping(value = "/restapi", method=RequestMethod.GET)
    @Autowired
    private BookService bookService;

    @GetMapping("/restapi")
    public List<Book> getBooks(){

       /*  Book book = new Book();
        book.setId(1);
        book.setAuthor("hlo");
        book.setTitle("physics");*/
        return this.bookService.get();

    }
    @GetMapping("/restapi/{id}")
    public Book getBook(@PathVariable("id")int id){
        return bookService.getbyid(id);
        
    }
    @PostMapping("/restapi")

    public Book addBook( @RequestBody Book book){
        Book b = this.bookService.addBook(book);
        return b;
    }  
    // delete book
    @DeleteMapping("/restapi/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId){
        this.bookService.deleteBook(bookId);
    }

    //
    @PutMapping("/restapi/{bookId}")
    public Book updateBook(@RequestBody Book book,@PathVariable("bookId")int bookId){
        this.bookService.updateBook(book,bookId);
        return book;
    }


    
}
 