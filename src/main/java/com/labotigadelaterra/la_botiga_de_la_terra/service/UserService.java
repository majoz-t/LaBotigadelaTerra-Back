package com.labotigadelaterra.la_botiga_de_la_terra.service;

import com.labotigadelaterra.la_botiga_de_la_terra.dto.request.RegisterRequestDTO;
import com.labotigadelaterra.la_botiga_de_la_terra.entity.User;

public interface UserService {

    public User registerUser(RegisterRequestDTO dto);

    void deleteUser(int id);

    //public User findByEmail(String email);

}
