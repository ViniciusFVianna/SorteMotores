package br.com.sudosu.sortemotores.domain;

import java.io.Serializable;

/**
 *
 * @author Vinicius Vianna
 */
public class Servico implements Serializable{
    
    private static long serialVersionUID = 1L;
    private Long idServico;
    private String Tipo;
    private String descricao;
    private int produto;
    private int cliente;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        Servico.serialVersionUID = serialVersionUID;
    }

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Servico{" + "idServico=" + idServico + ", Tipo=" + Tipo + ", descricao=" + descricao + ", produto=" + produto + ", cliente=" + cliente + '}';
    }
    
    
}
