package br.com.sudosu.sortemotores.rest;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.Application;

/**
 *
 * @author Vinicius Vianna
 */
public class MyApplication extends Application {

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("jersey.config.server.provider.packages", "br.com.sudosu");
        return properties;
    }

}//fecha classe
