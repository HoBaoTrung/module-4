package com.codegym.medicaldeclaration;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MedicalDeclarationService {
    private final Map<Long, MedicalDeclaration> dataStore = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public List<MedicalDeclaration> findAll() {
        return new ArrayList<>(dataStore.values());
    }

    public void save(MedicalDeclaration declaration) {
        if (declaration.getId() == null) {
            declaration.setId(idCounter.getAndIncrement());
        }
        dataStore.put(declaration.getId(), declaration);
    }

    public MedicalDeclaration findById(Long id) {
        return dataStore.get(id);
    }
}
