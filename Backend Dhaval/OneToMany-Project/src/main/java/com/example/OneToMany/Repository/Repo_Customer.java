package com.example.OneToMany.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OneToMany.MainEntity.Entity_Customer;

public interface Repo_Customer extends JpaRepository<Entity_Customer, Long> {

}
