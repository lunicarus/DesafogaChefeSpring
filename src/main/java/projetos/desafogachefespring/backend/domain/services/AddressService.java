package projetos.desafogachefespring.backend.domain.services;

import org.springframework.stereotype.Service;
import projetos.desafogachefespring.backend.domain.entities.Address;
import projetos.desafogachefespring.backend.domain.repositories.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }


    public List<Address> findAll() {
        return addressRepository.findAll();
    }


    public Address updateAddress(Long id, Address updatedAddress) {
        return addressRepository.findById(id)
                .map(existingAddress -> {
                    existingAddress.setStreet(updatedAddress.getStreet());
                    existingAddress.setCity(updatedAddress.getCity());
                    existingAddress.setState(updatedAddress.getState());
                    existingAddress.setPostalCode(updatedAddress.getPostalCode());
                    return addressRepository.save(existingAddress);
                })
                .orElseThrow(() -> new IllegalArgumentException("Address not found with ID: " + id));
    }


    public void deleteAddress(Long id) {
        if (!addressRepository.existsById(id)) {
            throw new IllegalArgumentException("Address not found with ID: " + id);
        }
        addressRepository.deleteById(id);
    }
}
