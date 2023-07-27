package com.example.core.controller.controllerRedundant;

import com.example.core.model.modelRedundant.Company;
import com.example.core.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany() {
        List<Company> allCompany = companyService.getAllCompany();

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(allCompany);
    }

    @PostMapping
    public ResponseEntity<Company> saveCompany(@RequestBody Company company) {
        Company companyObject = companyService.saveCompany(company);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(companyObject);
    }
}
