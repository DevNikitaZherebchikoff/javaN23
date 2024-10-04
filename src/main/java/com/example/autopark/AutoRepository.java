package com.example.autopark;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AutoRepository extends JpaRepository<AutoORM, Long> {
    @Query("SELECT p FROM AutoORM p WHERE CONCAT(p.mark, ' ', p.year, ' ', p.accDate, ' ', p.owner, ' ') LIKE %:keyword%")
    List<AutoORM> search(String keyword);
}
