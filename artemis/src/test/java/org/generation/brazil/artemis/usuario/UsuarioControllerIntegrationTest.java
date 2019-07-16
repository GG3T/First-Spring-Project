package org.generation.brazil.artemis.usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.github.javafaker.Faker;
import org.generation.brazil.artemis.ArtemisApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Locale;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ArtemisApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsuarioControllerIntegrationTest {

  @Autowired
  private TestRestTemplate testRestTemplate;

  @LocalServerPort
  private int port;

  /**
   * Monta a URL para a chamada de teste da API
   * @param path - caminho da API
   * @return String
   */
  private String getRootUrl(String path) {
    return "http://localhost:" + port + "/api/v1" + path;
  }

  @Test
  public void testaCriacaoDeUmNovoUsuario() {

    // "Chamada da API"
    ResponseEntity<Usuario> postResponse =
        testRestTemplate.postForEntity(
            getRootUrl("/usuarios"),
            UsuarioMock.getUsuarioMock(),
            Usuario.class);

    assertNotNull(postResponse);
    assertEquals(201,
        postResponse.getStatusCodeValue());
  }
  @Test
  public void testaConsultaDeTodosOsUsuario(){

    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String>  entity = new HttpEntity<>(null, headers);
    ResponseEntity<String> response = testRestTemplate.exchange(getRootUrl("/usuarios"),
            HttpMethod.GET, entity, String.class);
    assertNotNull(response.getBody());
    assertEquals(200, response.getStatusCodeValue());


  }

  @Test
  public void testUpdateEmployee() {
    Faker faker = new Faker(new Locale("pt-BR"));
    int id = 1;
    Usuario usuario = testRestTemplate.getForObject(getRootUrl("/usuarios/" + id), Usuario.class);
    usuario.setNome(faker.name().fullName());
    usuario.setEmail(faker.internet().emailAddress());
    usuario.setLogin(faker.name().username());
    usuario.setSenha(faker.internet().password());
    testRestTemplate.put(getRootUrl( "/usuarios/" + id), usuario);
    Usuario updatedUsuario = testRestTemplate.getForObject(getRootUrl( "/usuarios/" + id), Usuario.class);
    assertNotNull(updatedUsuario);
  }
  @Test
  public void testDeleteUsuario() {
    int id = 2;
    Usuario usuario = testRestTemplate.getForObject(getRootUrl("/usuarios/" + id), Usuario.class);
    assertNotNull(usuario);
    testRestTemplate.delete(getRootUrl("/usuarios/" + id));
    try {
      usuario = testRestTemplate.getForObject(getRootUrl("/usuarios/" + id), Usuario.class);
    } catch (final HttpClientErrorException e) {
      assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
    }
  }

  @Test
  public void testaConsultaPorId(){

  }

}