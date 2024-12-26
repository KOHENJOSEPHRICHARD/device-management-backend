package com.phone.smart.Service;


import com.phone.smart.Model.Device;
import com.phone.smart.Repository.EnergyConsumption;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
class EnergyConsumptionService {

    public EnergyConsumption energyConsumptionRepository;

    public EnergyConsumptionService(EnergyConsumption energyConsumptionRepository) {
        this.energyConsumptionRepository = energyConsumptionRepository;
    }

    public com.phone.smart.Model.EnergyConsumption logEnergyConsumption(Device device, double consumption) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        com.phone.smart.Model.EnergyConsumption energyConsumption = new com.phone.smart.Model.EnergyConsumption(device, consumption, timestamp);
        return (com.phone.smart.Model.EnergyConsumption) energyConsumptionRepository.save(energyConsumption);
    }
}
