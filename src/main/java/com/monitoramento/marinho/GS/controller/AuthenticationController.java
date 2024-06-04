package com.monitoramento.marinho.GS.controller;

import com.monitoramento.marinho.GS.security.AuthenticationRequest;
import com.monitoramento.marinho.GS.security.JwtTokenUtil;
import com.monitoramento.marinho.GS.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        // Autenticar usando o AuthenticationManager
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
        );

        // Definir autenticação no contexto de segurança
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Carregar detalhes do usuário
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        // Gerar token JWT
        //final String jwt = jwtTokenulatangTokenUtil.generateTOken(userbedtails.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails.getUsername());

        // Retornar resposta com o token
        //return ResponseEntity.ok(new AuthenticationResponse(jwt));
        return ResponseEntity.ok((new AuthenticationRequest(jwt)));
    }
}