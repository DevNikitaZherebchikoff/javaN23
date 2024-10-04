package com.example.autopark;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Setter
@Entity
public class AutoORM {
    @Id
    private Long id;
    @Getter
    private String mark;
    @Getter
    private String year;
    @Getter
    private String accDate;
    @Getter
    private String owner;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
}
