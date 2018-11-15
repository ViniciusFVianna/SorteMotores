package br.com.sudosu.sortemotores.dao;

import br.com.sudosu.sortemotores.domain.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinicius Vianna
 */
public class ProdutoDAO extends BaseDAO{
    public Produto getProdutoById(Long id) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("select * from produto where idProduto=?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Produto p = createProduto(rs);
                rs.close();
                return p;
            }
        }finally{
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }
    public List<Produto>findByName(String name) throws SQLException{
        List<Produto> produtos = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("select * from produto where lower(nome) like ?");
            stmt.setString(1, "%" + name.toLowerCase() +"%");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Produto p = createProduto(rs);
                produtos.add(p);
            }
            rs.close();
        } finally{
              if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return produtos;
    }
    public List<Produto>findByModelo(String modelo) throws SQLException{
        List<Produto> produtos = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("select * from produto where lower(modelo) like ?");
            stmt.setString(1, "%" + modelo.toLowerCase() +"%");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Produto p = createProduto(rs);
                produtos.add(p);
            }
            rs.close();
        } finally{
              if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return produtos;
    }
    public List<Produto>getProduto() throws SQLException{
        List<Produto> produtos = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("select * from produto");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Produto p = createProduto(rs);
                produtos.add(p);
            }
            rs.close();
        } finally{
              if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return produtos;
    }
    public Produto createProduto(ResultSet rs) throws SQLException{
        Produto p = new Produto();
        p.setIdProduto(rs.getLong("idProduto"));
        p.setNome(rs.getString("nome"));
        p.setCodigo(rs.getLong("codigo"));
        p.setValorCompra(rs.getDouble("valorCompra"));
        p.setValorVenda(rs.getDouble("valorVenda"));
        p.setQtde(rs.getInt("quantidade"));
        
        
    }
    
}//fech\ classe