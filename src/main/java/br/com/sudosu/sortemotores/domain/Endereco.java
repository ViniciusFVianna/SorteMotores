package br.com.sudosu.sortemotores.domain;

import java.io.Serializable;

/**
 *
 * @author Vinicius Vianna
 */
public class Endereco implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Long idEndereco;
    private String rua;
    private String numero;
    private String bloco;
    private String quadra;
    private String bairro;
    private String cidade;
    private String CEP;
    private String UF;

    public Endereco() {
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getQuadra() {
        return quadra;
    }

    public void setQuadra(String quadra) {
        this.quadra = quadra;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    @Override
    public String toString() {
        return "Endereco{" + "idEndereco=" + idEndereco + 
                ", rua=" + rua + 
                ", numero=" + numero + 
                ", bloco=" + bloco + 
                ", quadra=" + quadra + 
                ", bairro=" + bairro + 
                ", cidade=" + cidade + 
                ", CEP=" + CEP + 
                ", UF=" + UF + '}';
    }
    
    
    
}//fecha classe