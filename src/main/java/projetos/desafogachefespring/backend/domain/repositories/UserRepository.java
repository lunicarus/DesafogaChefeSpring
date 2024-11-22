package projetos.desafogachefespring.backend.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projetos.desafogachefespring.backend.domain.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
