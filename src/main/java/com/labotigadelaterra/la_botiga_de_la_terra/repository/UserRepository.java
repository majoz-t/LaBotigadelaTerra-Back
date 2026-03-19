package com.labotigadelaterra.la_botiga_de_la_terra.repository;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labotigadelaterra.la_botiga_de_la_terra.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

    boolean existsByEmail(String email);

    //Optional<User> findByEmail(String email);
}
