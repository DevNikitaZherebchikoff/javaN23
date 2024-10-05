package com.example.autopark;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

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
    private String date;
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
