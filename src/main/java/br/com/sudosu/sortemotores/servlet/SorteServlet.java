package br.com.sudosu.sortemotores.servlet;

import br.com.sudosu.sortemotores.domain.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
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
public class SorteServlet extends HttpServlet{
    
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String requestUri = req.getRequestURI();
        Long id = RegexUtil.matchId(requestUri);
        if(id != null){
            Response r = Response.Ok("Carro excluído com sucesso");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(r);
            ServletUtil.writeJoson(resp, json);
        }else{
            //URL inválida
            resp.sendError(404, "URL inválida");
        }
    }
}
