package br.com.sudosu.sortemotores.dao;

import br.com.sudosu.sortemotores.domain.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinicius Vianna
 */
public class ProdutoDAO extends BaseDAO {

    public Produto getProdutoById(Long id) throws SQLException {
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
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }

    public List<Produto> findByName(String name) throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("select * from produto where lower(nome) like ?");
            stmt.setString(1, "%" + name.toLowerCase() + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto p = createProduto(rs);
                produtos.add(p);
            }
            rs.close();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return produtos;
    }

    public List<Produto> findByModelo(String modelo) throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("select * from produto where lower(modelo) like ?");
            stmt.setString(1, "%" + modelo.toLowerCase() + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto p = createProduto(rs);
                produtos.add(p);
            }
            rs.close();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return produtos;
    }

    public List<Produto> getProduto() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("select * from produto");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto p = createProduto(rs);
                produtos.add(p);
            }
            rs.close();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return produtos;
    }

    public Produto createProduto(ResultSet rs) throws SQLException {
        Produto p = new Produto();
        p.setIdProduto(rs.getLong("idProduto"));
        p.setNome(rs.getString("nome"));
        p.setCodigo(rs.getLong("codigo"));
        p.setValorCompra(rs.getDouble("valorCompra"));
        p.setValorVenda(rs.getDouble("valorVenda"));
        p.setQtde(rs.getInt("quantidade"));
        return p;
    }

    public void save(Produto p) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            if (p.getIdProduto() == null) {
                stmt = conn.prepareStatement("insert into produto(nome, marca, modelo, codigo, valorCompra, valorVenda, quantidade)values('?, ?, ?, ?, ?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS);
            } else {
                stmt = conn.prepareStatement("update produto set nome=?,marca=?, modelo=? , codigo=?, valorCompra=?, valorVenda=?, quantidade=?");
            }
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getMarca());
            stmt.setString(3, p.getModelo());
            stmt.setString(4, p.getCodigo().toString());
            stmt.setDouble(5, p.getValorCompra());
            stmt.setDouble(6, p.getValorVenda());
            stmt.setInt(7, p.getQtde());
            if (p.getIdProduto() != null) {
//                Update
                stmt.setLong(8, p.getIdProduto());
            }
            int count = stmt.executeUpdate();
            if (count == 0) {
                throw new SQLException("Erro ao inserir o produto");
            }
            //Se inseriu, ler o id auto incremento
            if (p.getIdProduto() == null) {
                Long id = getGenerateId(stmt);
                p.setIdProduto(id);
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
//    id gerado com campo auto increment

    public static Long getGenerateId(Statement stmt) throws SQLException {
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            Long id = rs.getLong(1);
            return id;
        }
        return 0L;
    }
    public boolean delete(Long id) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("delete from produto where idProduto=?");
            stmt.setLong(1, id);
            int count = stmt.executeUpdate();
            boolean ok = count > 0;
            return ok;
        } finally {
             if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
    
}//fech\ classe
