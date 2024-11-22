package projetos.desafogachefespring.backend.domain.controllers;

import org.springframework.web.bind.annotation.*;
import projetos.desafogachefespring.backend.domain.services.CompanyService;
import projetos.desafogachefespring.backend.domain.entities.Company;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/")
    public Company createCompany(@RequestBody Company company) {
        return companyService.createCompany(company);
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable Long id) {
        return companyService.findById(id).orElseThrow(() -> new IllegalArgumentException("Company not found"));
    }

    @GetMapping("/")
    public List<Company> getAllCompanies() {
        return companyService.findAll();
    }

    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable Long id, @RequestBody Company updatedCompany) {
        return companyService.updateCompany(id, updatedCompany);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
    }
}
