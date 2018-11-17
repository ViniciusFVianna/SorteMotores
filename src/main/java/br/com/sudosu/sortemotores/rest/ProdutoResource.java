package br.com.sudosu.sortemotores.rest;

import br.com.sudosu.sortemotores.services.ProdutoService;
import br.com.sudosu.sortemotores.domain.Produto;
import br.com.sudosu.sortemotores.domain.Response;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vinicius Vianna
 */
@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Component
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService = new ProdutoService();

    @GET
    public List<Produto> get() {
        List<Produto> produtos = produtoService.getProdutos();
        return produtos;
    }

    @GET
    @Path("{id}")
    public Produto get(@PathParam("id") Long id) {
        Produto p = produtoService.getProduto(id);
        return p;
    }

    @GET
    @Path("/modelo/{modelo}")
    public List<Produto> getByModelo(@PathParam("modelo") String modelo) {
        List<Produto> p = produtoService.findByModelo(modelo);
        return p;
    }

    @GET
    @Path("/nome/{nome}")
    public List<Produto> getByNome(@PathParam("nome") String nome) {
        List<Produto> p = produtoService.findByName(nome);
        return p;
    }
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id){
        produtoService.delete(id);
        return Response.Ok("Produto deletado com sucesso");
    }
    @POST
    public Response post(Produto p){
        produtoService.save(p);
        return Response.Ok("Produto salvo com sucesso");
    }
    @PUT
    public Response put(Produto p){
        produtoService.save(p);
        return Response.Ok("Produto atualizado com sucesso");
    }
}
