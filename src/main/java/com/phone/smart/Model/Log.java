package com.phone.smart.Model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private String logLevel;

    @Column(nullable = false)
    private String timestamp;

    public Log(String message, String createdBy, String logLevel, String timestamp) {
        this.message = message;
        this.createdBy = createdBy;
        this.logLevel = logLevel;
        this.timestamp = timestamp;
    }
}