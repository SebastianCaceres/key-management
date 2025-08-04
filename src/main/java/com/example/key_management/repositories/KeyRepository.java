package com.example.key_management.repositories;


import com.example.key_management.entities.Key;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KeyRepository extends JpaRepository<Key, Long> {
    List<Key> findBySerialNumberContaining(String serialNumber);
    Optional<Key> findById(Long id);
    Key findBySerialNumber(String serialNumber);
}