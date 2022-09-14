package com.gft.receitas.repositories;

import com.gft.receitas.entities.Role;
import com.gft.receitas.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarregadorDados implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {

        Role admin = new Role();
        admin.setNomeRole("ROLE_ADMIN");
        roleRepository.save(admin);

        Role user = new Role();
        user.setNomeRole("ROLE_USER");
        roleRepository.save(user);


        List<Role> usuario01Roles = new ArrayList<>();
        usuario01Roles.add(admin);
        Usuario usuario01 = new Usuario();
        usuario01.setLogin("admin@gft.com");
        usuario01.setNomeCompleto("Admin Padrão");
        usuario01.setSenha("$2a$10$dc8NE4lANepuhsdwLlcX0eQYxF0crg28/waukgKMzWU8IKtwtL.Qy");
        usuario01.setRoles(usuario01Roles);
        usuarioRepository.save(usuario01);

        List<Role> usuario02Roles = new ArrayList<>();
        usuario02Roles.add(user);
        Usuario usuario02 = new Usuario();
        usuario02.setLogin("usuario@gft.com");
        usuario02.setNomeCompleto("Usuário Padrão");
        usuario02.setSenha("$2a$10$dc8NE4lANepuhsdwLlcX0eQYxF0crg28/waukgKMzWU8IKtwtL.Qy");
        usuario02.setRoles(usuario02Roles);
        usuarioRepository.save(usuario02);
    }
}
