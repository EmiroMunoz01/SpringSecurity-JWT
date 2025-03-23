package com.security.springsecurity.security;


import lombok.Data;

@Data
public class AuthCredendials {
    private String email;
    private String password;

    //crear servicio que se encargara de poder cargar un usuario desde la bd apartir de lo que le identifica, en este caso el email y el password

}
