package org.brazil.generation.demo.usuario;

import net.bytebuddy.utility.RandomString;
import org.brazil.generation.demo.SpringTestApplication;
import org.brazil.generation.demo.controller.UsuarioController;
import org.brazil.generation.demo.model.Usuario;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsuarioControllerIntegrationTeste {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    /**
     * Monta a URL para a chamada de teste da API
     * @param path caminho da API
     * @return rteporta API
     */

    private String getRootUrl(String path){
        return "http://localhost:" + port + "/api/v1" + path;

    }

    @Test
    public void testaCriaçãoDeUmNovoUsuario() {
        //Cria um novo usuario
        Usuario usuario = new Usuario();
        usuario.setNome(RandomString.make(15));
        usuario.setEmail(RandomString.make(15) );
        usuario.setLogin(RandomString.make(15));
        usuario.setSenha(RandomString.make(15));
        usuario.setUserx(RandomString.make(15));

        public void mock() {
            //Cria um novo usuario


            usuario.setNome(RandomString.make(15));
            usuario.setEmail(RandomString.make(15) );
            usuario.setLogin(RandomString.make(15));
            usuario.setSenha(RandomString.make(15));
            usuario.setUserx(RandomString.make(15));

        // chamada da API

      ResponseEntity<Usuario> postResponse =
              testRestTemplate.postForEntity(
                      getRootUrl ( "/usuario"),usuario, Usuario.class);
                         UsuarioMock.UsuarioMock(), Usuario.class)
      assertNotNull(postResponse);
      assertEquals(201, postResponse.getStatusCodeValue());
    }


}
