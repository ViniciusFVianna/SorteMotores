package br.com.sudosu.sortemotores.servlet;

import br.com.sudosu.sortemotores.domain.Produto;
import br.com.sudosu.sortemotores.domain.Response;
import br.com.sudosu.sortemotores.services.ProdutoService;
import br.com.sudosu.sortemotores.util.RegexUtil;
import br.com.sudosu.sortemotores.util.ServletUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vinicius Vianna
 */
@WebServlet("/sortemotores/*")
public class SorteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ProdutoService produtoService = new ProdutoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String requestUri = req.getRequestURI();
        Long id = RegexUtil.matchId(requestUri);
        if (id != null) {
            Produto produto = produtoService.getProduto(id);
            if(produto != null){
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String json = gson.toJson(produto);
                ServletUtil.writerJSON(resp, json);
            }else{
                resp.sendError(404, "Produto não encrontrado");
            }
        }else{
            List<Produto> produtos = produtoService.getProdutos();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(produtos);
            ServletUtil.writerJSON(resp, json);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestUri = req.getRequestURI();
        Long id = RegexUtil.matchId(requestUri);
        if (id != null) {
            Response r = Response.Ok("Produto excluído com sucesso");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(r);
            ServletUtil.writerJSON(resp, json);
        } else {
            //URL inválida
            resp.sendError(404, "URL inválida");
        }
    }
}
