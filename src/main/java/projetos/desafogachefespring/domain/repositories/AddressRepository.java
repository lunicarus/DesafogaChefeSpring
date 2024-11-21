package projetos.desafogachefespring.domain.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import projetos.desafogachefespring.domain.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
