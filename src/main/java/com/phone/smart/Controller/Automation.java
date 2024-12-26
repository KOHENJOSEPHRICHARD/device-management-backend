package com.phone.smart.Controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/automations")
@RequiredArgsConstructor
public class Automation {
    final com.phone.smart.Service.Automation automationService;

    // Get all automations
    @GetMapping
    public ResponseEntity<List<com.phone.smart.Model.Automation>> getAllAutomations() {
        List<com.phone.smart.Model.Automation> automations = automationService.getAllAutomations();
        return ResponseEntity.ok(automations);
    }

    // Get a specific automation by ID
    @GetMapping("/{id}")
    public ResponseEntity<com.phone.smart.Model.Automation> getAutomationById(@PathVariable Long id) throws Throwable {
        com.phone.smart.Model.Automation automation = automationService.getAutomationById(id);
        return ResponseEntity.ok(automation);
    }

    // Create a new automation
    @PostMapping
    public ResponseEntity<com.phone.smart.Model.Automation> createAutomation(@RequestBody com.phone.smart.Model.Automation automation) {
        com.phone.smart.Model.Automation createdAutomation = automationService.createAutomation(automation);
        return ResponseEntity.ok(createdAutomation);
    }

    // Update the status of an automation
    @PutMapping("/{id}/status")
    public ResponseEntity<com.phone.smart.Model.Automation> updateAutomationStatus(@PathVariable Long id, @RequestParam boolean isActive) throws Throwable {
        com.phone.smart.Model.Automation updatedAutomation = automationService.updateAutomationStatus(id, isActive);
        return ResponseEntity.ok(updatedAutomation);
    }

    // Update an automation
    @PutMapping("/{id}")
    public ResponseEntity<com.phone.smart.Model.Automation> updateAutomation(@PathVariable Long id, @RequestBody com.phone.smart.Model.Automation updatedAutomation) throws Throwable {
        com.phone.smart.Model.Automation automation = automationService.updateAutomation(id, updatedAutomation);
        return ResponseEntity.ok(automation);
    }

    // Delete an automation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutomation(@PathVariable Long id) throws Throwable {
        automationService.deleteAutomation(id);
        return ResponseEntity.noContent().build();
    }
    
}

