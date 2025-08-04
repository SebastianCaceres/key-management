package com.example.key_management.repositories;

import com.example.key_management.entities.View;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ViewRepository {
    private final View currentView = new View(); // initialize with default values

    public View findCurrentView() {
        return currentView;
    }

    public void save(View view) {
        // Update the single instance with new values
        this.currentView.setSearchBySerialNumber(view.getSearchBySerialNumber());
        this.currentView.setFilterByStatus(view.getFilterByStatus());
        this.currentView.setSearchByUpdatedBy(view.getSearchByUpdatedBy());
        this.currentView.setSearchByUpdated(view.getSearchByUpdated());
        this.currentView.setTheme(view.getTheme());
        this.currentView.setViewType(view.getViewType());

    }
}