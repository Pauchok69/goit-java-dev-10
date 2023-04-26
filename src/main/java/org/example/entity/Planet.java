package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Planet {
    @Id
    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private Identifier id;

    private String name;

    public enum Identifier {
        MERCURY,
        VENUS,
        EARTH,
        MARS,
        JUPITER,
        SATURN,
        URANUS,
        NEPTUNE,
        PLUTO
    }
}
