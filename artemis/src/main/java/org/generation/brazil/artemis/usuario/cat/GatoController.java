package org.generation.brazil.artemis.usuario.cat;


import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.generation.brazil.artemis.usuario.UsuarioController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
public class GatoController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @GetMapping("/gatos/{statusCode}")
    public String obtemGatoDoCodigoDeStatus(@PathVariable Integer statusCode){
        String retorno = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url ("https://viacep.com.br/ws/04548000/json" + statusCode).get().build();
                try{
                    Response response = client.newCall (request).execute();
                    retorno = String.valueOf(response.body());
                } catch (IOException e) {
                    logger.info("Ocorreu um erro na hora de consumir a API de gaitnhos");
                }
                return retorno;
    }
}
