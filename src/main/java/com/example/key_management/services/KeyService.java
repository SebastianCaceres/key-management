package com.example.key_management.services;

import com.example.key_management.entities.Key;
import com.example.key_management.entities.View;
import com.example.key_management.repositories.KeyRepository;
import com.example.key_management.repositories.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KeyService {
    @Autowired
    private KeyRepository keyRepository;
    @Autowired
    private ViewRepository viewRepository;

    public KeyService(KeyRepository keyRepository, ViewRepository viewRepository) {
        this.keyRepository = keyRepository;
        this.viewRepository = viewRepository;
    }

    public void initializeSampleKeys() {
        if (keyRepository.count() == 0) {
            // Create and save some sample keys
            Key key1 = new Key("1234","issued","seb", LocalDate.now());
            Key key2 = new Key("5678","returned","john", LocalDate.now());
            Key key3 = new Key("9012","issued","ivonne", LocalDate.now());

            keyRepository.save(key1);
            keyRepository.save(key2);
            keyRepository.save(key3);
        }
    }


    public List<Key> getKeys() {
        View view = viewRepository.findCurrentView();

        List<Key> keys;
        if (view.getSearchBySerialNumber() != null && !view.getSearchBySerialNumber().isEmpty()) {
            keys = keyRepository.findBySerialNumberContaining(view.getSearchBySerialNumber());
        } else {
            keys = keyRepository.findAll();
        }

        return keys.stream()
/*
                .filter(key -> key.getStatus().equals(view.getFilterByStatus()))
*/
                .collect(Collectors.toList());
    }

    public void updateView(View view) {
        viewRepository.save(view);
    }

    public View getCurrentView() {
        return viewRepository.findCurrentView();
    }

    // methods to issue, return, and update keys (unchanged)
}