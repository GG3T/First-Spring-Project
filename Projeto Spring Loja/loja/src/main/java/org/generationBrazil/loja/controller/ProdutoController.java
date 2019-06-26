package org.generationBrazil.loja.controller;

import org.generationBrazil.loja.controller.dao.ProdutoDAO;
import org.generationBrazil.loja.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoDAO produtoDAO;

    public ProdutoController(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    @RequestMapping("/lista-produtos")
    public List<Produto> lista() {

      return  (List<Produto>) produtoDAO.findAll();


}

}
