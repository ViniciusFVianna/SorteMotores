package br.com.sudosu.sortemotores.rest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.jettison.JettisonFreature;

/**
 *
 * @author Vinicius Vianna
 */
public class MyApplication extends Application {

    @Override
    public Set<Object> getSingletons() {
        Set<Object> singletons = new HashSet<>();
        singletons.add(new JettisonFreature());
        return singletons;
    }

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("jersey.config.server.provider.packages", "br.com.sudosu");
        return properties;
    }

}//fecha classe
