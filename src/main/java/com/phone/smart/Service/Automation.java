package com.phone.smart.Service;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Automation {

    public com.phone.smart.Repository.Automation automationRepository;

    public Automation(com.phone.smart.Repository.Automation automationRepository) {
        this.automationRepository = automationRepository;
    }

    public List<com.phone.smart.Model.Automation> getAllAutomations() {
        return automationRepository.findAll();
    }

    public com.phone.smart.Model.Automation createAutomation(com.phone.smart.Model.Automation automation) {
        return (com.phone.smart.Model.Automation) automationRepository.save(automation);
    }

    public com.phone.smart.Model.Automation updateAutomationStatus(Long id, boolean isActive) throws Throwable {
        com.phone.smart.Model.Automation automation = (com.phone.smart.Model.Automation) automationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Automation not found"));
        automation.setActive(isActive);
        return (com.phone.smart.Model.Automation) automationRepository.save(automation);
    }


    public com.phone.smart.Model.Automation getAutomationById(Long id) {
        return getAutomationById(id);
    }

    public com.phone.smart.Model.Automation updateAutomation(Long id, com.phone.smart.Model.Automation updatedAutomation) {

        return updatedAutomation;
    }

    public void deleteAutomation(Long id) {
    }
}
