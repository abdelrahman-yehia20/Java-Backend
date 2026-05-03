package com.example.task1.email.repo;

import com.example.task1.email.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepo extends JpaRepository<Email,Long> {

    List<Email> findByIdIn(List<Long> ids);
    List<Email> findByNameIn(List<String> names);
    List<Email> findByName(String name);
    Email findByContent(String content);

}
