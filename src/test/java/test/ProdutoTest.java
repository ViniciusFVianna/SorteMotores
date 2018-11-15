//package test;
//
//import java.util.List;
//import br.com.sudosu.sortemotores.domain.Produto;
//import br.com.sudosu.sortemotores.services.ProdutoService;
//import junit.framework.TestCase;
//
///**
// *
// * @author Vinicius Vianna
// */
//public class ProdutoTest extends TestCase{
// private ProdutoService produtoService = new ProdutoService();
// public void testListaProdutos(){
//     List<Produto> produtos = produtoService.getProdutos();
//     assertNotNull(produtos);
//     //Valida se encontrou algo
//     assertTrue(produtos.size() > 0);
//     //Valida se encontrou placa
//     Produto placa433 = produtoService.findByName("Placa frequencia 433").get(0);
//     assertEquals("Placa frequencia 433", placa433.getNome());
//     
//     Produto placa299 = produtoService.findByName("Placa frequencia 299").get(0);
//     assertEquals("Placa frequencia 299", placa299.getNome());
//     Produto placa = produtoService.findByName("Placa frequencia 433").get(0);
//     assertEquals("Placa frequencia 433", placa.getNome());
//     Produto controle299 = produtoService.findByName("Controle frequencia 299").get(0);
//     assertEquals("Placa frequencia 433", controle299.getNome());
// }
//}