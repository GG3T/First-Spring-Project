package org.brazil.generation.demo.usuario;

import org.brazil.generation.demo.SpringTestApplication;
import org.brazil.generation.demo.model.Usuario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsuarioControllerIntegrationTeste {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl(){
        return "http://localhost:" + port;

    }
    @Test
    public void save() {
        Usuario usuario = new Usuario();
        usuario.setNome("João Maria");
        usuario.setEmail("joaomaria@gmail.com");
        usuario.setLogin("joaomaria");
        usuario.setSenha("@Joma987");
      //ResponseEntity<Usuario> postResponse = testRestTemplate.postForEntity(getRootUrl() + "/usuarios", Usuario.class);
    }
}
