package com.example.autopark;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoService {
    @Autowired
    private AutoRepository repo;

    public void save(AutoORM book) {
        repo.save(book);
    }

    public AutoORM get(Long id) {
        return repo.findById(id).get();
    }

    public List<AutoORM> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
