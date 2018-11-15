/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sudosu.sortemotores.domain;

import java.io.Serializable;

/**
 *
 * @author Vinicius Vianna
 */
public class Produto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Long idProduto;
    private String nome;
    private String marca;
    private String modelo;
    private Long codigo;
    private double valorCompra;
    private double valorVenda;
    private int qtde;

    public Produto() {
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    @Override
    public String toString() {
        return "Produto{" + "idProduto=" + idProduto + ", nome=" + nome + ", marca=" + marca + ", modelo=" + modelo + ", codigo=" + codigo + ", valorCompra=" + valorCompra + ", valorVenda=" + valorVenda + ", qtde=" + qtde + '}';
    }
}//fecha classe