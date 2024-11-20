package projetos.desafogachefespring.domain.services;

import projetos.desafogachefespring.domain.entities.User;
import projetos.desafogachefespring.domain.records.UserRecord;
import projetos.desafogachefespring.domain.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(UserRecord record) {
        User user = new User();
        user.setLogin(record.login());
        user.setPassword(passwordEncoder.encode(record.password()));
        user.setIsAdmin(record.isAdmin() != null ? record.isAdmin() : false);

        return userRepository.save(user);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, UserRecord record) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setLogin(record.login());
            existingUser.setPassword(passwordEncoder.encode(record.password()));
            existingUser.setIsAdmin(record.isAdmin());
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
