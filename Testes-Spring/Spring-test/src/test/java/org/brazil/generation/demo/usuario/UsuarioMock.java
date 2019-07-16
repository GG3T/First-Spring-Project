package org.brazil.generation.demo.usuario;

import com.github.javafaker.Faker;
import org.brazil.generation.demo.model.Usuario;

import java.util.Locale;

public class UsuarioMock {

        public static Usuario UsuarioMock(){
           Usuario usuario = new Usuario();
            Faker faker = new Faker(new Locale("pt-BR"));

            usuario.setNome(faker.name().fullName());
            usuario.setEmail(faker.internet().emailAddress());
            usuario.setLogin(faker.name().username());
            usuario.setSenha(faker.internet().password());

            return usuario;
    }


}
