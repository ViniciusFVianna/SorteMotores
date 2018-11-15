package br.com.sudosu.sortemotores.domain;

import java.io.Serializable;

/**
 *
 * @author Vinicius Vianna
 */
public class Cliente implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Long idCliente;
    private String nome;
    private String CPF;
    private int endereco;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public int getEndereco() {
        return endereco;
    }

    public void setEndereco(int endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nome=" + nome + ", CPF=" + CPF + ", endereco=" + endereco + '}';
    }
    
}//fecha classe