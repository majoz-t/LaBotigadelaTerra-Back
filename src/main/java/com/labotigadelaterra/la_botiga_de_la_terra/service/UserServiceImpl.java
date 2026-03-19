package com.labotigadelaterra.la_botiga_de_la_terra.service;

import org.springframework.stereotype.Service;

import com.labotigadelaterra.la_botiga_de_la_terra.dto.request.RegisterRequestDTO;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.User;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.enums.Role;
import com.labotigadelaterra.la_botiga_de_la_terra.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    
    public UserServiceImpl (UserRepository userRepository){
        this.userRepository= userRepository;
    }

    @Override
    public User registerUser(RegisterRequestDTO dto) {
       String email = dto.email().toLowerCase().trim();
       if (userRepository.existsByEmail(email)){
        throw new RuntimeException("El email ya está registrado");
       }
       User user = new User();
       user.setName(dto.name().trim());
       user.setEmail(email);
       user.setPassword(dto.password());
       user.setRole(Role.ROLE_PATIENT);

       return userRepository.save(user);
    }


    // @Override
    // public User findByEmail(String email) {
    //     return userRepository.findByEmail(email)
    //     .orElseThrow(()-> new RuntimeException("Usuario no encontrado"));
    // }

}
