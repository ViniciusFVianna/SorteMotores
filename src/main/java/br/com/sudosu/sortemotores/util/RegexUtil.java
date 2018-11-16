package br.com.sudosu.sortemotores.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;

/**
 *
 * @author Vinicius Vianna
 */
public class RegexUtil {
    private static final Pattern regexAll = Pattern.compile("/produtos");
    private static final Pattern regexById = Pattern.compile("/produtos/([0-9])");
    
    //Verifica se a URL é no padrão "/sortemotores/id
    public static Long matchId(String requestUri) throws ServletException{
        //Verifica o ID
        Matcher matcher = regexById.matcher(requestUri);
        if(matcher.find() && matcher.groupCount() > 0){
            String s = matcher.group(1);
            if (s != null && s.trim().length() > 0) {
                Long id = Long.parseLong(s);
                return id;
            }
        }
        return null;
    }
    //Verifica se a URL é no padrão "produtps/id"
    public boolean matchALL(String requestUri) throws ServletException{
        Matcher matcher = regexAll.matcher(requestUri);
        if(matcher.find()){
            return true;
        }
        return false;
    }
}