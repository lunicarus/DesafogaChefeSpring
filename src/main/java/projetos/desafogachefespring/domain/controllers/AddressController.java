package projetos.desafogachefespring.domain.controllers;

import org.springframework.web.bind.annotation.*;
import projetos.desafogachefespring.domain.entities.Address;
import projetos.desafogachefespring.domain.services.AddressService;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/")
    public Address createAddress(@RequestBody Address address) {
        return addressService.createAddress(address);
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable Long id) {
        return addressService.findById(id).orElseThrow(() -> new IllegalArgumentException("Address not found"));
    }

    @GetMapping("/")
    public List<Address> getAllAddresses() {
        return addressService.findAll();
    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable Long id, @RequestBody Address updatedAddress) {
        return addressService.updateAddress(id, updatedAddress);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
    }
}
