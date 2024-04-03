package com.restapi.restproject.dao;

import org.springframework.data.repository.CrudRepository;

import com.restapi.restproject.entity.Book;
import java.util.List;


public interface BookRepo  extends CrudRepository<Book,Integer> {
    public Book findById(int id);
}
