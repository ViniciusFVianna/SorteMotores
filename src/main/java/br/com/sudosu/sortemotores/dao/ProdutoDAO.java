package br.com.sudosu.sortemotores.dao;

import br.com.sudosu.sortemotores.domain.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.sterotype.Component;
import org.hibernate.Query;

/**
 *
 * @author Vinicius Vianna
 */
@Component
@SuppressWarnings("unchecked")
public class ProdutoDAO extends HibernateDAO<Produto> {

    public ProdutoDAO() {
       //Informa o tipo da entidade para o Hibernate
    super(Produto.class);
    }

    //Busca pelo id
    public Produto getProdutoById(Long id){
        //O Hibernate consulta automaticamente pelo id
        return super.get(id);
    }

    //Busca pelo nome
    public List<Produto> findByName(String nome) {
        Query q = getSession().createQuery("from Produto where lower(nome) like lower(?)");
        q.setString(0, "%"+ nome +"%");
        return q.list();
    }

    //Busca pelo modelo
    public List<Produto> findByModelo(String modelo){
        Query q = getSession().createQuery(" from Produto where modelo=?");
            q.setString(0, modelo);
            List<Produto> produtos = q.list();
            return produtos;
    }

    //Consulta todos os produtos
    public List<Produto> getProduto() {
        Query q = getSession().createQuery(" from Produto");
        List<Produto> produtos = q.list();
        return produtos;
    }

    //Insere ou atualiza um produto
    public void salvar(Produto p){
       super.save(p);
    }
    
    //deleta pelo id
    public boolean delete(Long id){
        Produto p = get(id);
        delete(p);
        return true;
    }
}//fech\ classe
