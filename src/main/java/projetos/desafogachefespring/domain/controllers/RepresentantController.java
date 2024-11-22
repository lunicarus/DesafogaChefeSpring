package projetos.desafogachefespring.domain.controllers;

import org.springframework.web.bind.annotation.*;
import projetos.desafogachefespring.domain.entities.Representant;
import projetos.desafogachefespring.domain.records.RepresentantRequest;
import projetos.desafogachefespring.domain.services.RepresentantService;

import java.util.List;

@RestController
@RequestMapping("/representants")
public class RepresentantController {

    private final RepresentantService representantService;

    public RepresentantController(RepresentantService representantService) {
        this.representantService = representantService;
    }

    @PostMapping("/")
    public Representant createRepresentant(@RequestBody RepresentantRequest request) {
        return representantService.createRepresentant(request);
    }

    @GetMapping("/{id}")
    public Representant getRepresentantById(@PathVariable Long id) {
        return representantService.findById(id).orElseThrow(() -> new IllegalArgumentException("Representant not found with ID: " + id));
    }

    @GetMapping("/")
    public List<Representant> getAllRepresentants() {
        return representantService.findAll();
    }

    @PutMapping("/{id}")
    public Representant updateRepresentant(@PathVariable Long id,@RequestBody RepresentantRequest request) {
        return representantService.updateRepresentant(id,request);
    }

    @DeleteMapping("/{id}")
    public void deleteRepresentant(@PathVariable Long id) {
        representantService.deleteRepresentant(id);
    }
}
