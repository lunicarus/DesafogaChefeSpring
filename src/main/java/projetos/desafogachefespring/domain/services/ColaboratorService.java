package projetos.desafogachefespring.domain.services;

import projetos.desafogachefespring.domain.entities.Colaborator;
import projetos.desafogachefespring.domain.entities.Company;
import projetos.desafogachefespring.domain.entities.Representant;
import projetos.desafogachefespring.domain.entities.User;
import projetos.desafogachefespring.domain.records.ColaboratorRequest;
import projetos.desafogachefespring.domain.repositories.ColaboratorRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColaboratorService {

    private final ColaboratorRepository colaboratorRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public ColaboratorService(ColaboratorRepository colaboratorRepository, PasswordEncoder passwordEncoder, UserService userService) {
        this.colaboratorRepository = colaboratorRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    public Colaborator createColaborator(ColaboratorRequest request) {
          User user = userService.createUser(request.userRecord());

        Colaborator colaborator = new Colaborator();

        colaborator.setUser(user);
        colaborator.setColaboratorName(request.colaboratorRecord().name());
        colaborator.setWorkSchedule(request.colaboratorRecord().workSchedule());
        colaborator.setJob(request.colaboratorRecord().job());
        colaborator.setCPF(request.colaboratorRecord().CPF());

        return colaboratorRepository.save(colaborator);
    }

    public Optional<Colaborator> findById(Long id) {
        return colaboratorRepository.findById(id);
    }

    public List<Colaborator> findAll() {
        return colaboratorRepository.findAll();
    }

    public Colaborator updateColaborator(Long id, ColaboratorRequest request) {
        return colaboratorRepository.findById(id).map(existingColaborator -> {
            User user = userService.updateUser(request.userRecord().id(),request.userRecord());


            existingColaborator.setColaboratorName(request.colaboratorRecord().name());
            existingColaborator.setWorkSchedule(request.colaboratorRecord().workSchedule());
            existingColaborator.setJob(request.colaboratorRecord().job());
            existingColaborator.setCPF(request.colaboratorRecord().CPF());
            existingColaborator.setUser(user);
            return colaboratorRepository.save(existingColaborator);
        }).orElseThrow(() -> new IllegalArgumentException("Colaborator not found with id: " + id));
    }

    public void deleteColaborator(Long id) {
        colaboratorRepository.deleteById(id);
    }
}
