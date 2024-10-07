package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Entity
public class TheatreORM {
    @Id
    private Long id;
    @Getter
    private String name;
    @Getter
    private String artistsName;
    @Getter
    private LocalDate date;
    @Getter
    private String time;
    @Getter
    private String valueOfTickets;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
}
