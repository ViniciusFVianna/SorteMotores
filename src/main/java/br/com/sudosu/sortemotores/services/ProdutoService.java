package br.com.sudosu.sortemotores.services;

import br.com.sudosu.sortemotores.dao.ProdutoDAO;
import br.com.sudosu.sortemotores.domain.Produto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vinicius Vianna
 */
@Component
public class ProdutoService {

    @Autowired
    private ProdutoDAO db;

//    Lista de todos os produtos do banco de dados
    public List<Produto> getProdutos() {
        List<Produto> produtos = db.getProduto();
        return produtos;
    }

//    Busca produto pelo id
    public Produto getProduto(Long id) {
        return db.getProdutoById(id);
    }
    
//    Deleta o produto pelo id
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Long id) {
        return db.delete(id);
    }
    
//    Salva ou atualiza o produto
    @Transactional(rollbackFor = Exception.class)
    public boolean save(Produto produto) {
        db.saveOrUpdate(produto);
        return true;
    }
    
//      Busca o produto pelo nome
    public List<Produto> findByName(String name) {
        return db.findByName(name);
    }

    public List<Produto> findByModelo(String modelo) {
        return db.findByModelo(modelo);
    }
}//fecha classe
