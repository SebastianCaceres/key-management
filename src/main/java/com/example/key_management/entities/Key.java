package com.example.key_management.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "keyTable")
public class Key {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serialNumber;
    private String status;
    private String updatedBy;
    private LocalDate updated;

    public Key(String serialNumber, String status, String updatedBy, LocalDate updated) {
        this.serialNumber = serialNumber;
        this.status = status;
        this.updatedBy = updatedBy;
        this.updated = updated;
    }
}
