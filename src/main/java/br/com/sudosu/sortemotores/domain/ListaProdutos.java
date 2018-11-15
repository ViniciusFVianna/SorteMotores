package br.com.sudosu.sortemotores.domain;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 *
 * @author Vinicius Vianna
 */
@XmlRootElement(name = "produtos")
public class ListaProdutos implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Produto> produtos;

    @XmlElement(name = "produto")
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos){
        this.produtos = produtos;
    }
    @Override
    public String toString(){
        return "ListaProdutos[produtos=" + produtos +"]";
    }
}