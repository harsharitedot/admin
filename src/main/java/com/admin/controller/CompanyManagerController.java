package com.admin.controller;

import com.admin.dto.CompanyManagerDTO;
import com.admin.service.CompanyManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company-managers")
public class CompanyManagerController {

    private final CompanyManagerService managerService;

    public CompanyManagerController(CompanyManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping
    public ResponseEntity<List<CompanyManagerDTO>> getAllManagers() {
        return ResponseEntity.ok(managerService.getAllManagers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyManagerDTO> getManagerById(@PathVariable Long id) {
        return ResponseEntity.ok(managerService.getManagerById(id));
    }

    @PostMapping
    public ResponseEntity<CompanyManagerDTO> createManager(@RequestBody CompanyManagerDTO managerDTO) {
        return ResponseEntity.ok(managerService.createManager(managerDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyManagerDTO> updateManager(@PathVariable Long id, @RequestBody CompanyManagerDTO managerDTO) {
        return ResponseEntity.ok(managerService.updateManager(id, managerDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteManager(@PathVariable Long id) {
        managerService.deleteManager(id);
        return ResponseEntity.ok("Manager deleted successfully!");
    }
}
