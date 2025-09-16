package com.ufpb.GestorRepositorios.services;

import com.ufpb.GestorRepositorios.exception.ItemNotFoundException;
import com.ufpb.GestorRepositorios.models.User;
import com.ufpb.GestorRepositorios.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> listUsers() {
        return this.userRepository.findAll();
    }

    public User getUserById(Long id) {
        return this.userRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("User not found"));
    }

    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User toUpdate = this.userRepository
                .findById(id)
                .orElseThrow(() -> new ItemNotFoundException("User not found"));
        toUpdate.setNome(user.getNome());
        toUpdate.setEmail(user.getEmail());
        toUpdate.setPhoto(user.getPhoto());
        toUpdate.setOrganizacoes(user.getOrganizacoes());
        return this.userRepository.save(toUpdate);
    }

    public void deleteUser(Long id) {
        if (!this.userRepository.existsById(id)) {
            throw new ItemNotFoundException("User not found");
        }
        this.userRepository.deleteById(id);
    }

}
