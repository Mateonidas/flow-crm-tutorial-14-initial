package com.example.application.data.repository;

import com.example.application.data.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ContactRepository extends JpaRepository<Contact, UUID> {

    @Query("SELECT c FROM Contact c " +
            "WHERE LOWER(c.firstName) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
            "OR LOWER(c.lastName) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<Contact> search(@Param("searchTerm") String searchTerm);
}
