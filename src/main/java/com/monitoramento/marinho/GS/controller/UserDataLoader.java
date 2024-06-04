package com.monitoramento.marinho.GS.controller;
import com.monitoramento.marinho.GS.entity.Incident;
import com.monitoramento.marinho.GS.entity.User;
import com.monitoramento.marinho.GS.repository.IncidentRepository;
import com.monitoramento.marinho.GS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;



@Component
public class UserDataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    IncidentRepository incidentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {


//        userRepository.save(new User("user1", passwordEncoder.encode("password123")));

      Incident  incident = new Incident("Plastico no Mar", "Lixos espalhados perto de ninho de tartaruga", "Amazonas", LocalDateTime.now());
        userRepository.save(new User("usertest", passwordEncoder.encode("password123")));
        User usuario2 = new User("user2", passwordEncoder.encode("password123"), "teste", Arrays.asList(incident));

        // Salvamento do usuário e seus incidentes
        incident.setUsuario(usuario2);
        userRepository.save(usuario2);

        incidentRepository.save(incident);
    }
}