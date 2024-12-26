package com.phone.smart.Repository;

import com.phone.smart.Model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    // Additional custom query methods (if needed) can be added here.
    // For example, you can find devices by type or location.

    // Example: Find devices by status
    List<Device> findByStatus(String status);

    // Example: Find devices by owner id (assuming `owner` is a field in Device)
    List<Device> findByOwnerId(Long ownerId);
}
