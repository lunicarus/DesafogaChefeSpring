package projetos.desafogachefespring.backend.domain.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import projetos.desafogachefespring.backend.domain.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
