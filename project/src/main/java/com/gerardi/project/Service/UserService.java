package com.gerardi.project.Service;

import com.gerardi.project.dto.UserDTO;
import com.gerardi.project.entities.User;
import com.gerardi.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll() {
        return this.userRepository.findAll().stream().map(x -> new UserDTO(x.getId(), x.getName(), x.getEmail(), x.getPassword())).collect(Collectors.toList());
    }

    public UserDTO findById(Integer id) {
        User user = this.userRepository.findById(id).get();
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPassword());
    }

    public User insertUser(User user) {
        return this.userRepository.save(user);
    }

    public User updateUser(User newUser, Integer id) {
        User oldUser = this.userRepository.findById(id).get();
        oldUser.setName(newUser.getName());
        oldUser.setEmail(newUser.getEmail());
        oldUser.setPassword(newUser.getPassword());
        return this.userRepository.save(oldUser);
    }

    public void deleteUser(Integer id) {
        this.userRepository.deleteById(id);
    }
}
