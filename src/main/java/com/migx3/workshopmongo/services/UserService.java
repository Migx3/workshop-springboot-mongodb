package com.migx3.workshopmongo.services;

import com.migx3.workshopmongo.domain.User;
import com.migx3.workshopmongo.dto.UserDTO;
import com.migx3.workshopmongo.repositories.UserRepository;
import com.migx3.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);

        return user.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User user) {
        return repository.insert(user);
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User update(User user) {
        User newUser = findById(user.getId());

        updateData(user, newUser);
        return repository.save(newUser);
    }

    private void updateData(User user, User newUser) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }
}