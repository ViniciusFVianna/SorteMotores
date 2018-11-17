package test;

import java.util.List;
import br.com.sudosu.sortemotores.domain.Produto;
import br.com.sudosu.sortemotores.services.ProdutoService;
import junit.framework.TestCase;

/**
 *
 * @author Vinicius Vianna
 */
public class ProdutoTest extends TestCase{
 private ProdutoService produtoService;
 @Override
 protected void setUp() throws Exception{
     super.setUp();
     //Cria o "bean" pelo Spring.
     produtoService = (produtoService) SpringUtil.getInstance().getBean(ProdutoService.class);
 }
 public void testListaProdutos(){
     //Não muda nada aqui
 }
 public void testSalvarDeletar(){
     //Não muda nada aqui
 }
}