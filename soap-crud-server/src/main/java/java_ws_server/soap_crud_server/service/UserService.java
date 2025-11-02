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
            if (user.getNome() != null) {
                user.setNome(newUser.getNome());
            }
            if (user.getEmail() != null) {
                user.setEmail(newUser.getEmail());
            }
            if (user.getDt_nascimento() != null) {
                user.setDt_nascimento(newUser.getDt_nascimento());
            }
            if (user.getCpf() != null) {
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
