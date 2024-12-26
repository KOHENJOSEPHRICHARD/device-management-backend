package com.phone.smart.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "energy_consumptions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnergyConsumption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    @Column(nullable = false)
    private double consumption; // kWh or other units

    @Column(nullable = false)
    private String timestamp;

    public EnergyConsumption(Device device, double consumption, String timestamp) {
    }
}