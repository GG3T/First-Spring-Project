package org.generationBrazil.loja.controller.dao;

import org.generationBrazil.loja.model.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdutoDAO extends CrudRepository<Produto, Long> {


}
