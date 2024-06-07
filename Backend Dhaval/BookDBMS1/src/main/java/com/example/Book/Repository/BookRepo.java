package com.example.Book.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.Book.Entity.BookEntity;

public interface BookRepo extends CrudRepository<BookEntity, Integer> {

}
