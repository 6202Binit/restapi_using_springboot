package com.restapi.restproject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restapi.restproject.dao.BookRepo;
import com.restapi.restproject.entity.Book;


@Component
public class BookService {
    @Autowired
    private BookRepo bookRepo;
  //  private static List<Book>list = new ArrayList<>();
   /*  static{
        list.add(new Book(12,"java","binit"));
        list.add(new Book(13,"spring","ravi"));
        list.add(new Book(14,"python","niraj"));
    }*/
    public List<Book> get(){
        List<Book> list = (List<Book>)this.bookRepo.findAll();
        return list;
    }
    public Book getbyid(int id){
       // Book book = null;
        // book = list.stream().filter(e->e.getId()==id).findFirst().get();
       Book book = this.bookRepo.findById(id);
        return book;
    }
    public Book addBook(Book b){
       // list.add(b);
       Book result = this.bookRepo.save(b); 
        return result;
    }
    //delete book
    public void deleteBook(int bid){
        //list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());
        bookRepo.deleteById(bid);

    }

    public void updateBook(Book book,int bookId){
       /*   list = list.stream().map(b->{
            if(b.getId()==bookId){
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());*/
        book.setId(bookId);
        bookRepo.save(book);
    }
}
