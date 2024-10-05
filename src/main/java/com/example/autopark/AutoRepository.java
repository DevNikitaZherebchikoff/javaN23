package com.example.autopark;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AutoRepository extends JpaRepository<TheatreORM, Long> {
    @Query("SELECT p FROM TheatreORM p WHERE CONCAT(p.name, ' ', p.artistsName, ' ', p.date, ' ', p.time, ' ', p.valueOfTickets, ' ') LIKE %:keyword%")
    List<TheatreORM> search(String keyword);
}
