package br.com.sudosu.sortemotores.services;

import br.com.sudosu.sortemotores.dao.ProdutoDAO;
import br.com.sudosu.sortemotores.domain.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframwork.stereotype.Component;

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
        try {
            List<Produto> produtos = db.getProduto();
            return produtos;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
//    Busca produto pelo id
    public Produto getProduto(Long id){
        try{
            return db.getProdutoById(id);
        }catch(SQLException e){
           return null;
        }
    }
//    Deleta o produto pelo id
    public boolean delete(Long id){
        try{
            return db.delete(id);
        }catch(SQLException e){
            return false;
        }
    }
//    Salva ou atualiza o produto
      public boolean save(Produto produto){
          try{
              db.save(produto);
              return true;
          }catch(SQLException e){
              return false;
          }
      }
//      Busca o produto pelo nome
      public List<Produto> findByName(String name){
          try{
             return db.findByName(name);
          }catch(SQLException e){
              return null;
          }
      }
      public List<Produto> findByModelo(String modelo){
          try {
              return db.findByModelo(modelo);
          } catch (SQLException e) {
          return null;
          }
      }
}//fecha classe
