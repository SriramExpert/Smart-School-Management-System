package com.example.edusphere.Service;

import com.example.edusphere.Entity.MarkEntry;
import com.example.edusphere.Repository.MarkEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkEntryTestService {
    @Autowired
    private MarkEntryRepository markEntryRepository;

    public void savemethod(List<MarkEntry> markEntryList) {
        markEntryRepository.saveAll(markEntryList);
    }
}
