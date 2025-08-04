package com.example.key_management.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class View {
    private String searchBySerialNumber;
    private String filterByStatus="";
    private String searchByUpdatedBy;
    private LocalDate searchByUpdated;
    private String theme = "light"; // Default theme is light
    private String viewType = "grid"; // Default view is grid
}
