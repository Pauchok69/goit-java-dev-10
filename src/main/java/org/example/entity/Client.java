package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;
}
