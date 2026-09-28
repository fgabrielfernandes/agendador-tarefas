package com.javanauta.agendadortarefas.infraestructure.security;



import com.javanauta.agendadortarefas.business.dto.UsuarioDTO;
import com.javanauta.agendadortarefas.infraestructure.client.UsuarioClient;
import com.javanauta.usuario.infraesctructure.entity.Usuario;
import com.javanauta.usuario.infraesctructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl{

    @Autowired
    private UsuarioClient client;

    public UserDetails carregaDadosUsuario(String email, String token){

        UsuarioDTO dto = client.buscarUsuarioPorEmail(email, token);
        return User
                .withUsername(dto.getEmail()) // Define o nome de usuário como o e-mail
                .password(dto.getSenha()) // Define a senha do usuário
                .build();
    }
}
