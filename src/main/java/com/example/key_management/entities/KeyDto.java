package com.example.key_management.entities;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class KeyDto {
    private String serialNumber;
    private String status;
    private String signatureData;
    private String updatedBy;
    private LocalDate updated;
}
