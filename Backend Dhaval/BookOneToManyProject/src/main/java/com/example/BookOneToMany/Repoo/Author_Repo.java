package com.example.BookOneToMany.Repoo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookOneToMany.Entity.AuthorMain_Entity;

public interface Author_Repo extends JpaRepository<AuthorMain_Entity, Long> {

}
