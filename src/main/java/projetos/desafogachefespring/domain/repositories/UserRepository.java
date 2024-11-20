package projetos.desafogachefespring.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projetos.desafogachefespring.domain.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
