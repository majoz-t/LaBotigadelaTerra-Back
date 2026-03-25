package com.labotigadelaterra.la_botiga_de_la_terra.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterRequestDTO( 
    @NotBlank(message = "El nombre es requerido")
    @Size(min = 2, max = 50, message = "El nombre deberá tener entre 2 y 50 caracteres")
    String name, 
    @NotBlank(message = "El email es requerido")
    @Email(message = "El formato del email es inválido")
    String email, 
    @NotBlank(message = "La contraseña es requerida")
    @Size(min = 6, max = 15, message = "La contraseña deberá tener entre 6 y 15 caracteres")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d).+$", message = "La contraseña debe contener letras y números")
    String password
) {
   
}
