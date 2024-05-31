package com.monitoramento.marinho.GS.service;

import com.monitoramento.marinho.GS.entity.User;
import com.monitoramento.marinho.GS.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;



import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserService {
private UserRepository userRepository;
private PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, PasswordEncoder passwordLoader){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordLoader;

    }

    @Transactional
    public User createUser(@NotNull User user) {
        String encodePassword =passwordEncoder.encode(user.getSenha());
        user.setSenha(encodePassword);
        return userRepository.save(user);
    }
    public Optional<User>getUserById(Long id){
        return userRepository.findById(id);


    }
    public Optional<User>GetUserByUsuario(String usuario){
        return userRepository.findByUsuario(usuario);
    }

}
