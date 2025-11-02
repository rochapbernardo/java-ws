package java_ws_server.soap_crud_server.service;

import java_ws_server.soap_crud_server.entity.User;
import java_ws_server.soap_crud_server.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(User user) {
        if (user.getNome() == null || user.getNome().isBlank()) {
            throw new IllegalArgumentException("User name cannot be empty");
        }
        if (user.getCpf() == null || user.getCpf().isBlank()) {
            throw new IllegalArgumentException("User CPF cannot be empty");
        }
        return repository.save(user);
    }

    public Optional<User> getUserById(int id) {
        return repository.findById(id);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User updateUser(int id, User newUser) {
        User user = this.getUserById(id).get();
        if (this.getUserById(id).isPresent()) {
            if (newUser.getNome() != null && !newUser.getNome().isBlank()) {
                user.setNome(newUser.getNome());
            }
            if (newUser.getEmail() != null && !newUser.getEmail().isBlank()) {
                user.setEmail(newUser.getEmail());
            }
            if (newUser.getDt_nascimento() != null && !newUser.getDt_nascimento().isBlank()) {
                user.setDt_nascimento(newUser.getDt_nascimento());
            }
            if (newUser.getCpf() != null && !newUser.getCpf().isBlank()) {
                user.setCpf(newUser.getCpf());
            }
            return repository.save(user);
        } else {
            throw new NoSuchElementException("Update not performed, user not found by ID");
        }
    }

    public void deleteUser(int id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("User not found by ID");
        }
        repository.deleteById(id);
    }
}
