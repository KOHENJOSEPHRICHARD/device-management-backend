package com.phone.smart.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "automations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Automation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String trigger;

    @Column(nullable = false)
    private String action;

    @Column(nullable = false)
    private String description;

    private boolean isActive = true;  // Automation enabled or disabled

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
