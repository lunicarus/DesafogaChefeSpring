package projetos.desafogachefespring.backend.domain.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetos.desafogachefespring.backend.domain.entities.Colaborator;
import projetos.desafogachefespring.backend.domain.records.ColaboratorRequest;
import projetos.desafogachefespring.backend.domain.services.ColaboratorService;

import java.util.List;

@RestController
@RequestMapping("/colaborators")
public class ColaboratorController {

    private final ColaboratorService colaboratorService;

    public ColaboratorController(ColaboratorService colaboratorService) {
        this.colaboratorService = colaboratorService;
    }

    @PostMapping
    public ResponseEntity<Colaborator> createColaborator(@RequestBody ColaboratorRequest request) {
        Colaborator colaborator = colaboratorService.createColaborator(request);
        return ResponseEntity.ok(colaborator);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colaborator> getColaboratorById(@PathVariable Long id) {
        return colaboratorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Colaborator>> getAllColaborators() {
        return ResponseEntity.ok(colaboratorService.findAll());
    }

    @GetMapping("/available-for-loan")
    public ResponseEntity<List<Colaborator>> getAvailableForLoan() {
        return ResponseEntity.ok(colaboratorService.findAvailableForLoan());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colaborator> updateColaborator(@PathVariable Long id, @RequestBody ColaboratorRequest request) {
        try {
            Colaborator updatedColaborator = colaboratorService.updateColaborator(id, request);
            return ResponseEntity.ok(updatedColaborator);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColaborator(@PathVariable Long id) {
        colaboratorService.deleteColaborator(id);
        return ResponseEntity.noContent().build();
    }
}
