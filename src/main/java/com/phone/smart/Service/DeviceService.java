package com.phone.smart.Service;

import com.phone.smart.Model.Device;
import com.phone.smart.Repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService {

    @Autowired
    private final DeviceRepository deviceRepository;


    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }


    public Device addDevice(Device device) {
        device.setLastUpdated(LocalDateTime.now()); // Set the current timestamp
        return (Device) deviceRepository.save(device);
    }


    public Device updateDeviceStatus(Long id, String status) throws Throwable {
        Device device = (Device) deviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));
        device.setStatus(status);
        device.setLastUpdated(LocalDateTime.now()); // Update the last updated timestamp
        return (Device) deviceRepository.save(device);
    }

    public Device getDeviceById(Long id) throws Throwable {
        return (Device) deviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));
    }


    public Device updateDevice(Long id, Device updatedDevice) throws Throwable {
        Device existingDevice = (Device) deviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));

        // Update fields
        existingDevice.setName(updatedDevice.getName());
        existingDevice.setType(updatedDevice.getType());
        existingDevice.setStatus(updatedDevice.getStatus());
        existingDevice.setLocation(updatedDevice.getLocation());
        existingDevice.setConnected(updatedDevice.isConnected());
        existingDevice.setLastUpdated(LocalDateTime.now());

        return (Device) deviceRepository.save(existingDevice);
    }


    public void deleteDevice(Long id) throws Throwable {
        Device device = (Device) deviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));
        deviceRepository.delete(device);
    }
}

